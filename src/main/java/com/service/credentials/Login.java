package com.service.credentials;

import com.service.dao.Database;
import com.service.tools.Email;
import com.service.tools.Encryption;

public class Login {
	
	private String userName;
	private String password;
	
	public Login(String userName , String password) {
		
		this.userName = userName;
		this.password = password;
	
	}
	
	public boolean loginUser() {
		Database database = Database.getInstance();
		Encryption encryption = Encryption.getInstance();
		String encryptedPassword = encryption.encrypt(password);
		boolean isLogged = database.selectUserDetails(userName, encryptedPassword);
		return isLogged;
	}
	
	public String getUserCode() {
		Database database = Database.getInstance();
		String userCode = database.selectUserCode(userName);
		return userCode;
	}
	
	public String getImageCode(String userCode) {
		Database database = Database.getInstance();
		String imageCode = database.selectImageCode(userCode);
		return imageCode;
	}
}
