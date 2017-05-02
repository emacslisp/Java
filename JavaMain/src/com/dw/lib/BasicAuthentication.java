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
	}
	
	public static String GetBase64AuthCode(String username,String password)	{
		String authString = username + ":" + password;
		System.out.println("auth string: " + authString);
		byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
		String authStringEnc = new String(authEncBytes);
		//System.out.println("Base64 encoded auth string: " + authStringEnc);
		return authStringEnc;
	}

}