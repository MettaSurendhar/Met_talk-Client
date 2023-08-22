package com.service.tools;


import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.service.dao.Database;


public class Email extends Thread {

	private final String strFromMailId = "msurendhar8815@gmail.com";
	private final String strAppPassword = "zkxhqcyncmyzlsbd";
	private final String strSmtpHostServer = "smtp.gmail.com";
	private String mailId;
	private String otp;
	
	public Email(String mailId , String otp) {
		this.mailId = mailId;
		this.otp = otp;
	}
	
	@Override
	public void run() {
		super.run();
		try {
			
			System.out.println("\n\t[ Reterieved the MAIL from db ....... ] \n");
			
			Properties objProps = System.getProperties();
			objProps.put("mail.smtp.host", strSmtpHostServer);
			objProps.put("mail.smtp.starttls.enable", true);  
			objProps.put("mail.smtp.auth", "true");
			objProps.put("mail.smtp.port", "587"); 
			
			Session objSession = Session.getInstance(objProps, new javax.mail.Authenticator() { 
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(strFromMailId, strAppPassword);
				}
			});
			
			 System.out.println("\n\t[ PREPARING MAIL TO SEND ....... ] \n");
			
			
			MimeMessage msg = new MimeMessage(objSession);

			msg.setFrom(new InternetAddress(strFromMailId));
			msg.setSubject(" Verifying Mail "); 
			msg.setText("Please enter this otp to verify your Mail ID , OTP = \'" + otp + "\'");
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mailId, false));
			
			 System.out.println("\n\t[ MESSAGE IS READY TO SEND ....... ] \n");
			Transport.send(msg);
			System.out.println("\n ----------------- EMAIL SENT SUCCESSFULLY :) ----------------- \n");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}