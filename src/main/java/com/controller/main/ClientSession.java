package com.controller.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.chat.Client;
import com.service.dao.Database;
import com.service.main.ChatHandler;
import com.service.tools.JsonHandler;


@WebServlet("/ClientSession")
public class ClientSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Client client;
	private BufferedReader in;  
	
	private static final String LOCALHOST = "127.0.0.1" ;
       
    
    public ClientSession() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String strUserName = (String) session.getAttribute("userName");
		String strUserCode = (String) session.getAttribute("userCode");
		String strImageCode = (String) session.getAttribute("imageCode");
		String strUserDetails = strUserName + ":" + strUserCode + ":" + strImageCode;
		String strSessionID = request.getParameter("sessionID");
		
		Database database = Database.getInstance();
		String strPortNo = database.selectPortNo(strSessionID);
		if(strPortNo != null) {
			int portNo = Integer.parseInt(strPortNo);
					try {
						Socket socket = new Socket(LOCALHOST,portNo);
						client = new Client(socket,strUserDetails);
						boolean isUpdated = database.updateActiveUser(strUserCode,true);
						if(isUpdated) {
							response.sendRedirect("Chat.jsp");
						}
						client.listenMsg();
						client.sendMsg(strUserDetails);
							
					}
					catch(IOException e) {
						e.getStackTrace();
					}
		}
		else {
			response.sendRedirect("Expired.jsp");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		in = request.getReader();
		StringBuilder requestBody = new StringBuilder();
		JsonHandler jsonHandler = JsonHandler.getInstance();
		String line;
		
		while((line = in.readLine()) != null) {
			requestBody.append(line);
		}
		
		String json = requestBody.toString();
		
        String messageContent = jsonHandler.extractMessageContent(json);
        System.out.println("got the message : " + messageContent );
        if(!messageContent.equals(null)) client.sendMsg(messageContent);
        System.out.println("message handled");
        response.setStatus(HttpServletResponse.SC_OK);
	}
	

}
