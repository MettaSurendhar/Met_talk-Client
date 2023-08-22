package com.controller.authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.credentials.Login;
import com.service.dao.Database;


@WebServlet(description = "Used to login the user with username and password", urlPatterns = { "/SignIn" })

public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SignIn() {
        super();
        
    }
    
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	HttpSession session = request.getSession();
    	String strUserName = (String) session.getAttribute("userName");
    	Database database = Database.getInstance();
    	database.updateLogoutInfo(strUserName);
    	
    	session.removeAttribute("userName");
    	session.removeAttribute("userCode");
    	session.removeAttribute("imageCode");
    	session.invalidate();
    	
    	response.sendRedirect("SignIn.jsp");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String strUserName = request.getParameter("userName");
		String strPassword = request.getParameter("actualPassword");
		
		Database database = Database.getInstance();
		database.connect();
		
		Login login = new Login(strUserName,strPassword);
		boolean isLogged = login.loginUser();
		database.updateLoginInfo(strUserName);
		String strUserCode = login.getUserCode();
		String strImageCode = login.getImageCode(strUserCode);
		
		if(isLogged) {
			System.out.println("user logged in");
			HttpSession session = request.getSession();
			session.setAttribute("userName", strUserName);
			session.setAttribute("userCode", strUserCode);
			session.setAttribute("imageCode", strImageCode);
			
			response.sendRedirect("ClientSession.jsp");
			
		}else {
			response.sendRedirect("SignIn.jsp");
		}
		
		
	}

}
