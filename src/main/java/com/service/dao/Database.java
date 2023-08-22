package com.service.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

	static Connection con ;
	static PreparedStatement stmt ;
	static ResultSet rs ;
	
	private static Database instance;
	
	private Database() {}
	
	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}
	
	// -------------------------- CONNECTING TO THE "MYSQL" => "JAVA" DATABASE ------------------------------- //
	
	public void connect(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("database going to connected in db");
			Database.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/met_talk","root","Suren@19_2004");
			System.out.println("database connected in db");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void close() {
		try {
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	
	// -------------------------- ACCESSING THE DATABASE TO INSERT USER DATA ------------------------------- //
	
	public boolean insertUserDetails(String userName , String encryptedPassword , String email ,String userCode,String logInfo) {
		
		boolean isRegistered = false;

		try {
			if (con == null) {
				System.out.println(" con is null"); 
				return isRegistered;
            }
			stmt = con.prepareStatement("insert into user_details values(?,?,?,?,?)");      
			stmt.setString(1,userName);
			stmt.setString(2, encryptedPassword);
			stmt.setString(3, email);
			stmt.setString(4, userCode);
			stmt.setString(5, logInfo);
			
			stmt.executeUpdate();
			isRegistered = true;
		}
		catch(SQLException e){
			System.out.println("Error : " + e.getMessage());
		}
		finally {
			try {
				stmt.close();	
			}
			catch(Exception e){
				System.out.println("Error : " + e);
			}
		}
		
		return isRegistered ;
	}
	
// -------------------------- ACCESSING THE DATABASE TO INSERT USER DATA ------------------------------- //
	
	public boolean insertPersonalDetails(String userCode ,String firstName , String lastName , String status , String imageCode) {
		
		boolean isInserted = false;

		try {
			if (con == null) {
				System.out.println(" con is null"); 
				return isInserted;
            }
			stmt = con.prepareStatement("insert into personal_details values(?,?,?,?,?)");      
			stmt.setString(1,userCode);
			stmt.setString(2, firstName);
			stmt.setString(3, lastName);
			stmt.setString(4, status);
			stmt.setString(5, imageCode);
			
			stmt.executeUpdate();
			isInserted = true;
		}
		catch(SQLException e){
			System.out.println("Error : " + e.getMessage());
		}
		finally {
			try {
				stmt.close();	
			}
			catch(Exception e){
				System.out.println("Error : " + e);
			}
		}
		
		return isInserted ;
	}
	
	// -------------------------- ACCESSING THE DATABASE TO Update USER Code ------------------------------- //
	
	public boolean updateUserCode(String userName,String userCode) {
		
		boolean isUpdated = false;

		try {
			if (con == null) {
				System.out.println(" con is null"); 
				return isUpdated;
            }
			
			stmt = con.prepareStatement("update user_details set userCode=? where userName=?");
			stmt.setString(1,userCode);
			stmt.setString(2, userName);
			stmt.executeUpdate();
			isUpdated = true;
		}
		catch(SQLException e){
			System.out.println("Error : " + e.getMessage());
		}
		finally {
			try {
				stmt.close();	
			}
			catch(Exception e){
				System.out.println("Error : " + e);
			}
		}
		
		return isUpdated ;
	}

	// -------------------------- ACCESSING DATABASE TO SELECT ENCRYPTED PASSWORD FOR LOGIN  ------------------------------ //
	
	public boolean selectUserDetails(String userName , String encryptedPassword) {

		boolean isLogged = false;
		
		try {

			if (con == null) {
				System.out.println(" con is null"); 
				return isLogged;
            }
			stmt = con.prepareStatement("select encryptedPassword,logInfo from user_details where userName = ?");
			stmt.setString(1,userName);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String strGet = rs.getString(1);
				String strGetLog = rs.getString(2);
				if((strGet).equals((encryptedPassword)) && strGetLog.equals("false"))
					isLogged = true;
			}
		}
		catch(Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
		finally {
			try{
				stmt.close();
			}
			catch(Exception e){
				System.out.println("Error: " + e);
			}
		}
		
		return isLogged;
	}

	
	
	
	// ------------------------- ACCESSING THE DATABASE TO INSERT Image Data ------------------------------ //

	public boolean insertImage(String imageCode, String imageFileName) {
		
		boolean isUploaded = false;
		
		try {
			if (con == null) {
				System.out.println(" con is null"); 
				return isUploaded;
            }
			stmt = con.prepareStatement("insert into image_details values(?,?)");      
			stmt.setString(1,imageCode);
			stmt.setString(2, imageFileName);
			
			stmt.executeUpdate();
			isUploaded = true;
			System.out.println("uploaded at db");
		}
		catch(SQLException e){
			System.out.println("Error : " + e.getMessage());
		}
		finally {
			try {
				stmt.close();	
			}
			catch(Exception e){
				System.out.println("Error : " + e);
			}
		}
		
		return isUploaded;
	}
		
	// --------------------------- ACCESSING DATABASE TO SELECT EMAIL  ------------------------------ //
	
	public String selectEmail (String userName ) {

		String toEmail = null;
		
		try {
			stmt = con.prepareStatement("select email from user_details where userName = ?");
			stmt.setString(1,userName);
			rs = stmt.executeQuery();
			while(rs.next()) {
				toEmail = rs.getString(1);
			}
		}
		catch(SQLException e) {
			System.out.println("Error : " + e.getMessage());
		}
		finally {
			try {
				stmt.close();
			}
			catch(Exception e) {
				System.out.println("Error: " + e);
			}
		}
		
		return toEmail;
	}
	
	// --------------------------- ACCESSING DATABASE TO SELECT UserCode  ------------------------------ //
	
	public String selectUserCode (String userName) {

		String userCode = null ;
		
		try {
			stmt = con.prepareStatement("select userCode from user_details where userName = ?");
			stmt.setString(1,userName);
			rs = stmt.executeQuery();
			while(rs.next()) {
				userCode = rs.getString(1);
			}
		}
		catch(SQLException e) {
			System.out.println("Error : " + e.getMessage());
		}
		finally {
			try {
				stmt.close();
			}
			catch(Exception e) {
				System.out.println("Error: " + e);
			}
		}
		
		return userCode;
	}
	
	// --------------------------- ACCESSING DATABASE TO SELECT ImageCode  ------------------------------ //
	
	public String selectImageCode (String userCode) {

			String imageCode = null ;
			
			try {
				stmt = con.prepareStatement("select imageCode from personal_details where userCode = ?");
				stmt.setString(1,userCode);
				rs = stmt.executeQuery();
				while(rs.next()) {
					imageCode = rs.getString(1);
				}
			}
			catch(SQLException e) {
				System.out.println("Error : " + e.getMessage());
			}
			finally {
				try {
					stmt.close();
				}
				catch(Exception e) {
					System.out.println("Error: " + e);
				}
			}
			
			return imageCode;
		}
		

	// --------------------------- ACCESSING DATABASE TO SELECT PortNo  ------------------------------ //
	
		public String selectPortNo (String sessionId) {

			String portNO = null ;
			
			try {
				stmt = con.prepareStatement("select portNO from session_details where sessionId = ?");
				stmt.setString(1,sessionId);
				rs = stmt.executeQuery();
				while(rs.next()) {
					portNO = rs.getString(1);
				}
			}
			catch(SQLException e) {
				System.out.println("Error : " + e.getMessage());
			}
			finally {
				try {
					stmt.close();
				}
				catch(Exception e) {
					System.out.println("Error: " + e);
				}
			}
			
			return portNO;
		}
		
		// --------------------------- ACCESSING DATABASE TO SELECT Personal Info  ------------------------------ //
		
		public Map<String,String> selectPersonalInfo (String userCode) {

				Map<String, String> info = new HashMap<>();
				
				try {
					stmt = con.prepareStatement("select firstName,lastName,status from personal_details where userCode = ?");
					stmt.setString(1,userCode);
					rs = stmt.executeQuery();
					while(rs.next()) {
						info.put("firstName", rs.getString(1));
						info.put("lastName", rs.getString(2));
						info.put("status", rs.getString(3));
					}
				}
				catch(SQLException e) {
					System.out.println("Error : " + e.getMessage());
				}
				finally {
					try {
						stmt.close();
					}
					catch(Exception e) {
						System.out.println("Error: " + e);
					}
				}
				
				return info;
			}
			

		//-------------------------- ACCESSING THE DATABASE TO Update Active USers ------------------------------- //

	public boolean updateActiveUser(String userCode,boolean active) {
		
		boolean isUpdated = false;

		try {
			if (con == null) {
				System.out.println(" con is null"); 
				return isUpdated;
         }
			
			stmt = con.prepareStatement("update personal_details set active=? where userCode=?");
			stmt.setBoolean(1,active);
			stmt.setString(2, userCode);
			stmt.executeUpdate();
			isUpdated = true;
		}
		catch(SQLException e){
			System.out.println("Error : " + e.getMessage());
		}
		finally {
			try {
				stmt.close();	
			}
			catch(Exception e){
				System.out.println("Error : " + e);
			}
		}
		
		return isUpdated ;
	}
	
	// --------------------------- ACCESSING DATABASE TO SELECT Active Users  ------------------------------ //
	
		public List<String> selectUserCodes ( ) {
			
			List<String> userCodes =  new ArrayList<> ();
			
			try {
				stmt = con.prepareStatement("select userCode from personal_details where active=true");
				rs = stmt.executeQuery();
				while(rs.next()) {
					userCodes.add(rs.getString("userCode"));
				}
			}
			catch(SQLException e) {
				System.out.println("Error : " + e.getMessage());
			}
			finally {
				try {
					stmt.close();
				}
				catch(Exception e) {
					System.out.println("Error: " + e);
				}
			}
			
			return userCodes;
		}
		
		// --------------------------- ACCESSING DATABASE TO SELECT Login Info  ------------------------------ //
		
			public String selectLoginInfo (String userName) {

				String logInfo = null ;
				
				try {
					stmt = con.prepareStatement("select logInfo from user_details where userName = ?");
					stmt.setString(1,userName);
					rs = stmt.executeQuery();
					while(rs.next()) {
						logInfo = rs.getString(1);
					}
				}
				catch(SQLException e) {
					System.out.println("Error : " + e.getMessage());
				}
				finally {
					try {
						stmt.close();
					}
					catch(Exception e) {
						System.out.println("Error: " + e);
					}
				}
				
				return logInfo;
			}
			
			// --------------------------- ACCESSING DATABASE TO Update Login Info  ------------------------------ //
			
			public void updateLoginInfo (String userName) {
				
				try {
					if (con == null) {
						System.out.println(" con is null"); 
						return;
		         }
					
					stmt = con.prepareStatement("update user_details set logInfo=? where userName=?");
					stmt.setString(1, "true");
					stmt.setString(2, userName);
					stmt.executeUpdate();
					
				}
				catch(SQLException e){
					System.out.println("Error : " + e.getMessage());
				}
				finally {
					try {
						stmt.close();	
					}
					catch(Exception e){
						System.out.println("Error : " + e);
					}
				}
				
				return;
			}
			
			// --------------------------- ACCESSING DATABASE TO Update Login Info  ------------------------------ //
			
			public void updateLogoutInfo (String userName) {
				
				try {
					if (con == null) {
						System.out.println(" con is null"); 
						return;
		         }
					
					stmt = con.prepareStatement("update user_details set logInfo=? where userName=?");
					stmt.setString(1, "false");
					stmt.setString(2, userName);
					stmt.executeUpdate();
					
				}
				catch(SQLException e){
					System.out.println("Error : " + e.getMessage());
				}
				finally {
					try {
						stmt.close();	
					}
					catch(Exception e){
						System.out.println("Error : " + e);
					}
				}
				
				return;
			}
		
}
