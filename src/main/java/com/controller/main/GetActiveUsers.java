package com.controller.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.dao.Database;
import com.service.tools.JsonHandler;

@WebServlet("/getActiveUsers")

public class GetActiveUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out ;
	private List<Map<String,String>> activeUsersInfo ;
    
    public GetActiveUsers() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out = response.getWriter();
        
        Database database = Database.getInstance();
        List<String> userCodes = database.selectUserCodes();

        for (String userCode : userCodes) {
        	activeUsersInfo.add(database.selectPersonalInfo (userCode));
        }
        
        JsonHandler jsonHandler = JsonHandler.getInstance();
        String jsonUsers = jsonHandler.createJSONUsers(activeUsersInfo);
        out.print(jsonUsers);
        
	}

}
