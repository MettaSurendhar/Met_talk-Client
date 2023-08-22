package com.controller.main;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.tools.Email;
import com.service.tools.JsonHandler;

@WebServlet("/SendOtp")
public class SendOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BufferedReader in; 
       
    public SendOtp() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		in = request.getReader();
		StringBuilder requestBody = new StringBuilder();
		JsonHandler jsonHandler = JsonHandler.getInstance();
		String line = in.readLine();
		requestBody.append(line);	
		String json = requestBody.toString();
		
		String value = jsonHandler.extractMessageContent(json);
		String emailId = value.substring(6);
		String otp = value.substring(0,6);
      	Email email = new Email(emailId,otp);
		email.start();
		
		RequestDispatcher objReqDispatcher = request.getRequestDispatcher("SignUp.jsp");
		request.setAttribute("emailId", emailId);
		System.out.println("otp got:"+otp);
		request.setAttribute("otp", otp);
		objReqDispatcher.forward(request, response);
	}
	
//	private String extractMessageContent(String json) {
//	    String value = null;
//	    int startIndex = json.indexOf(":") + 2;
//	    int endIndex = json.lastIndexOf("\"");
//	    if (startIndex > 1 && endIndex > startIndex) {
//	        value = json.substring(startIndex, endIndex);
//	    }
//	    return value;
//	}

}
