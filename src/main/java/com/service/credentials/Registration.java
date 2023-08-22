package com.service.credentials;

import com.service.dao.Database;
import com.service.tools.Encryption;

public class Registration {

	private String userName;
	private String password;
	private String email;
	

	public Registration(String userName,String password , String email){
		
		this.userName = userName;
		this.password = password;
		this.email = email;
		
		
	}
	
	public boolean registerUser() {
		
		Database database = Database.getInstance();
		Encryption encryption = Encryption.getInstance();
		String encryptedPassword = encryption.encrypt(password);
		
		String userCode="0";
		String logInfo ="false";
		boolean isRegistered = database.insertUserDetails( userName, encryptedPassword, email,userCode,logInfo);	
		
		return isRegistered;
	}
	
}
