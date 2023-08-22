package com.service.main;

import com.service.dao.Database;
import com.service.tools.RandomString;
import javax.servlet.http.Part;


public class UserDataHandler {
	
	private String strUserName;
	private String strFirstName;
	private String strLastName;
	private String strStatus;
	private Part partFile;	
	private String strFileName;
	
	private String strImageCode;
	private String strUserCode;
	
	public UserDataHandler(String userName , String firstName,String lastName,String status,String fileName , Part file) {
		this.strUserName = userName;
		this.strFirstName = firstName;
		this.strLastName = lastName;
		this.strStatus = status;
		this.partFile = file;
		this.strFileName = fileName;
	}
	
	public boolean HandleUser() {
		boolean isUploaded = false;
		
		ImageHandler imageHandler = new ImageHandler(partFile,strFileName);
		this.strImageCode = imageHandler.getImageCode();
		imageHandler.setUploadPath(strImageCode);
		boolean isUploadedImage = imageHandler.uploadImage();
		
		this.strUserCode = setUserCode();
		
		Database database = Database.getInstance();
		boolean isUploadedData = database.insertPersonalDetails(strUserCode,strFirstName,strLastName,strStatus,strImageCode);
		boolean isUpdatedUserCode = database.updateUserCode(strUserName, strUserCode);
		
		if(isUploadedImage && isUploadedData && isUpdatedUserCode) {
			isUploaded = true;
		}
		return isUploaded;
	}
	
	public String setUserCode() {
		RandomString randomString = RandomString.getInstance();
		return randomString.getRandomString(7);
	}
}
