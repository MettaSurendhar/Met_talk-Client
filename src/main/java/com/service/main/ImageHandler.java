package com.service.main;

import javax.servlet.http.Part;

import com.service.dao.Database;
import com.service.tools.RandomString;
import com.service.tools.SaveFile;

public class ImageHandler {

	

	private String imageCode;
	private String uploadPath;
	private String imageFileName;
	
	private String actualFileName;
	private Part file;
	
	
	
	public ImageHandler( Part file ,String fileName) {
		this.file = file;
		this.actualFileName = fileName;
	}
	
	public String getImageCode() {
		RandomString randomString = RandomString.getInstance();
		return randomString.getRandomString(6);
	}
	
	public void setUploadPath(String imageCode) {
		
		this.imageCode = imageCode;
		String[] arrStrFileName = actualFileName.split("\\.");
		String strExtention = arrStrFileName[1];
		imageFileName = "profile-image-" + this.imageCode +"." + strExtention;		
		this.uploadPath = "D:/workspace_2_java/Met_talk/src/main/webapp/assets/images/user-images/" + imageFileName ;
		System.out.println("ready uploadpath");
	}
	
	
	
	public boolean uploadImage() {
		
		boolean isUploaded = false;
		Database database = Database.getInstance();
		isUploaded = database.insertImage(imageCode, imageFileName);
	
		if(isUploaded) {
			System.out.println("uploaded the file into the database");
			SaveFile saveImage = new SaveFile(file, uploadPath);
			saveImage.start();
		}
		
		return isUploaded;
		
	}
	
	
}
