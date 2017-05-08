package com.dw.lib.test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class OAuth2ClientId {

	public static String get_SHA_512_SecurePassword(String passwordToHash, String salt) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			try {
				md.update(salt.getBytes("UTF-8"));

				byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < bytes.length; i++) {
					sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
				}
				generatedPassword = sb.toString();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} 
		return generatedPassword;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*String s = get_SHA_512_SecurePassword(UUID.randomUUID().toString(),UUID.randomUUID().toString());
		
		System.out.println(s.substring(0,15));*/
		
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString());
		
	}

}
