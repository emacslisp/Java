package com.dw.lib;

import java.util.Base64;

public class BasicAuthentication {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "admin";
		String password = "admin";

		String authString = name + ":" + password;
		System.out.println("auth string: " + authString);
		byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
		String authStringEnc = new String(authEncBytes);
		System.out.println("Base64 encoded auth string: " + authStringEnc);
		
		System.out.println(BasicAuthentication.base64Decode("Vm9jdXNBcGlVc2VyOlVedHc5a3M2d3lNMkBzcQ"));
	}
	
	public static String base64Generator(String input) {
		if(input == null) return "";
		
		byte[] authEncBytes = Base64.getEncoder().encode(input.getBytes());
		String authStringEnc = new String(authEncBytes);
		return authStringEnc;
	}
	
	// try to decode Vm9jdXNBcGlVc2VyOlVedHc5a3M2d3lNMkBzcQ
	public static String base64Decode(String input) {
		if(input == null) return "";
		byte[] authDecodeBytes = Base64.getDecoder().decode(input);
		return new String(authDecodeBytes);
	}
	
	public static String GetBase64AuthCode(String username,String password)	{
		String authString = username + ":" + password;
		System.out.println("auth string: " + authString);
		byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
		String authStringEnc = new String(authEncBytes);
		//System.out.println("Base64 encoded auth string: " + authStringEnc);
		return authStringEnc;
	}
	
	public boolean auth(String username,String password, String dbUsername, String dbPassword, String salt) throws Exception {
		
		CryptoGenerator generator = new CryptoGenerator();
		if(username != dbUsername) return false;
		
		if(generator.generateValue(password + salt) != dbPassword) {
			return false;
		}
		
		return true;
	}
	
	// TODO: put all character together 
	public String randomPasswordGenerator() {
		String result = "";
		
		
		
		return result;
	}

}
