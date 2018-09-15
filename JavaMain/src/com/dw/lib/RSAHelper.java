package com.dw.lib;

import java.security.*;
import java.util.Base64;

import javax.print.attribute.standard.DateTimeAtCompleted;

import java.util.*;

public class RSAHelper {
	
	public static void main(String[] args) {
		try {
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
			random.setSeed((new Date()).toString().getBytes());
			kpg.initialize(4096, random);
	        //kpg.initialize(4096); 
	        
	        KeyPair kp = kpg.generateKeyPair();
	        
	        String privateKeyBody = Base64.getMimeEncoder().encodeToString( kp.getPrivate().getEncoded());
	        String publicKeyBody = Base64.getMimeEncoder().encodeToString( kp.getPublic().getEncoded());
	        
	        System.out.println ("-----BEGIN OPENSSH PRIVATE KEY-----");
	        System.out.println (privateKeyBody);
	        System.out.println ("-----END OPENSSH PRIVATE KEY-----");
	        System.out.println ("-----BEGIN PUBLIC KEY-----");
	        System.out.println (publicKeyBody);
	        System.out.println ("-----END PUBLIC KEY-----");
	        
	        String privateKeyString = "-----BEGIN OPENSSH PRIVATE KEY-----" + System.lineSeparator();
	        privateKeyString += (privateKeyBody + System.lineSeparator());
	        privateKeyString += "-----END OPENSSH PRIVATE KEY-----";
	        FileUtils utils = new FileUtils();
	        utils.stringToFile(privateKeyString, "/Users/ewu/test/id_rsa");
	        
	        String publicKeyString = "ssh-rsa " + publicKeyBody.replace(System.lineSeparator(), "");
	        publicKeyString += " java.gdb@gmail.com";
	        
	        utils.stringToFile(publicKeyString, "/Users/ewu/test/id_rsa.pub");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
