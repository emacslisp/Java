package com.dw.lib;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.UUID;

public class MD5Generator {

	public String generateValue() throws Exception {
		return generateValue(UUID.randomUUID().toString());
	}

	private static final char[] hexCode = "0123456789abcdef".toCharArray();

	public static String toHexString(byte[] data) {
		if (data == null) {
			return null;
		}
		StringBuilder r = new StringBuilder(data.length * 2);
		for (byte b : data) {
			r.append(hexCode[(b >> 4) & 0xF]);
			r.append(hexCode[(b & 0xF)]);
		}
		return r.toString();
	}

	public String generateValue(String param) throws Exception {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(param.getBytes());
			byte[] messageDigest = algorithm.digest();
			return toHexString(messageDigest);
		} catch (Exception e) {
			throw new Exception("OAuth Token cannot be generated.", e);
		}
	}
	
	public String generateFileValue(String filePath) throws Exception {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(Files.readAllBytes(Paths.get(filePath)));
			byte[] messageDigest = algorithm.digest();
			return toHexString(messageDigest);
		} catch (Exception e) {
			throw new Exception("Generate MD5 of file show exceptions: ", e);
		}
	}
	
	public static void main(String[] args) {
		MD5Generator m = new MD5Generator();
		try {
			System.out.println(m.generateFileValue("/Users/di.wu/test/1.json"));
			System.out.println(m.generateValue("1234"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
