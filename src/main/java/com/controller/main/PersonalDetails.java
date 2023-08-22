package com.controller.main;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.service.main.UserDataHandler;


@MultipartConfig
@WebServlet(description = "Used to update the user personal details", urlPatterns = { "/PersonalDetails" })

public class PersonalDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PersonalDetails() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strUserName = request.getParameter("userName");
		String strFirstName = request.getParameter("firstName");
		String strLastName = request.getParameter("lastName");
		String strStatus = request.getParameter("status");
		Part partFile = request.getPart("imageFile");	
		String strFileName = partFile.getSubmittedFileName();
		
		UserDataHandler userDataHandler = new UserDataHandler(strUserName,strFirstName,strLastName,strStatus,strFileName,partFile);
		boolean isHandled = userDataHandler.HandleUser();
		
		if(isHandled) {
			response.sendRedirect("SignIn.jsp");
		}
		else {
			response.sendRedirect("PersonalDetails.jsp");
		}

		
	}

}
