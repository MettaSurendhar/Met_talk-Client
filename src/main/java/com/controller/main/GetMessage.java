package com.controller.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.main.ChatHandler;
import com.service.tools.JsonHandler;


@WebServlet("/getMessage")

public class GetMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out ;
	
    public GetMessage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out = response.getWriter();
        
        List<String> incomingMessages = ChatHandler.getIncomingMessages();
        
        JsonHandler jsonHandler = JsonHandler.getInstance();
        String jsonMessages = jsonHandler.createJSONMessages(incomingMessages);
        out.print(jsonMessages);
        
	}	

}
