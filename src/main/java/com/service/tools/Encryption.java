package com.service.tools;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

import com.service.dao.Database;

import java.security.MessageDigest;

public class Encryption {
	
	private static Encryption instance;
	private final String ALGORITHM = "SHA-512";
	
	private Encryption() {}
	
	public static Encryption getInstance() {
		
		if (instance == null) {
			instance = new Encryption();
		}
		return instance;
	}
	
	// --------------- ENCRYTING THE PASSWORD USING SECURE HASH ALGORITH -------------------- //
	
		public String encrypt(String password) {  
			
			String strEncryptedValue = null;
			
			// --------------- [ SHA_512 -> 512bits -> 64char_plain_text ] -------------------- //
			try {
				
				MessageDigest instanceMd=MessageDigest.getInstance(ALGORITHM);
				byte byteMessageDigest[] = instanceMd.digest(password.getBytes());
				BigInteger bigInt = new BigInteger(1,byteMessageDigest);
				strEncryptedValue = bigInt.toString(16);

			}catch(NoSuchAlgorithmException e) {
				System.out.println(e.getMessage());
			}
			
			return strEncryptedValue;
		}

}
