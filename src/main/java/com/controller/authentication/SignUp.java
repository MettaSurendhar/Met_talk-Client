package com.controller.authentication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.credentials.Registration;
import com.service.dao.Database;


@WebServlet(description = "Used to Register an user with necessary details", urlPatterns = { "/SignUp" })

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SignUp() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher objReqDispatcher ;
		String strEmailAddr = request.getParameter("emailAddress");
		String strUserName = request.getParameter("userName");
		String strPassword = request.getParameter("actualPassword");
		
		
		Database database = Database.getInstance();
		database.connect();
		System.out.println("database is connected in signup");
		Registration registration = new Registration(strUserName,strPassword,strEmailAddr);
		boolean isRegistered = registration.registerUser();
		
		if(isRegistered) {
			objReqDispatcher =  request.getRequestDispatcher("PersonalDetails.jsp");
			objReqDispatcher.forward(request, response);
		}
		else {
			response.sendRedirect("SignUp.jsp");
		}
		
	}

}
