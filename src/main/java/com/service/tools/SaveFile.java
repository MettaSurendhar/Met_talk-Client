package com.service.tools;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

public class SaveFile extends Thread {
	
	private Part file;
	private String uploadPath;
	
	public SaveFile(Part file, String uploadPath) {
		this.file = file;
		this.uploadPath = uploadPath;
	}

	@Override
	public void run() {
		super.run();
		
		FileOutputStream fos = null ;
		InputStream in = null;
		
		try {
			fos = new FileOutputStream(uploadPath);
			in = file.getInputStream();
			byte[] data=new byte[in.available()];
			in.read(data);
			fos.write(data);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				fos.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("uploaded the file into the folder");
	}
}
