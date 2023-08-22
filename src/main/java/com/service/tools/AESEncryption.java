package com.service.tools;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryption {
	
	private SecretKeySpec secretKey;
    private byte[] key;
    private final String ALGORITHM = "AES";
    private static AESEncryption instance;
    
    private AESEncryption() {}
    
    public static AESEncryption getInstance() {
		
		if (instance == null) {
			instance = new AESEncryption();
		}
		return instance;
	}
    
    public void prepareSecreteKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    
    public String encrypt(String strToEncrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
    
    public String decrypt(String strToDecrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }


}

//public static void main(String[] args) {
//    final String secretKey = "secrete";
//
//    String originalString = "javaguides";
//
//    AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
//    String encryptedString = aesEncryptionDecryption.encrypt(originalString, secretKey);
//    String decryptedString = aesEncryptionDecryption.decrypt(encryptedString, secretKey);
//
//    System.out.println(originalString);
//    System.out.println(encryptedString);
//    System.out.println(decryptedString);
//}

//javaguides
//KGBmBZKY27xOHrL5t+LYAQ==
//javaguides
