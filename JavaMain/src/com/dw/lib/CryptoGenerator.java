package com.dw.lib;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.UUID;

public class CryptoGenerator {
	
	public enum CryptoType {
		MD5,
		SHA_1,
		SHA_256,
	}
	
	public final static String md5 = "MD5";
	public final static String sha_1 = "SHA-1";
	public final static String SHA_256 = "SHA-256";
	String algorithmType = "";
	
	public CryptoGenerator() {
		algorithmType = md5;
	}
	
	public CryptoGenerator(CryptoType cryptoType) {
		if(cryptoType== CryptoType.MD5) {
			algorithmType = md5;
		} else if(cryptoType== CryptoType.SHA_1) {
			algorithmType = sha_1;
		} else if(cryptoType== CryptoType.SHA_256) {
			algorithmType = SHA_256;
		}
	}

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
			MessageDigest algorithm = MessageDigest.getInstance(algorithmType);
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
			MessageDigest algorithm = MessageDigest.getInstance(algorithmType);
			algorithm.reset();
			algorithm.update(Files.readAllBytes(Paths.get(filePath)));
			byte[] messageDigest = algorithm.digest();
			return toHexString(messageDigest);
		} catch (Exception e) {
			throw new Exception("Generate MD5 of file show exceptions: ", e);
		}
	}
	
	public void printSupportAlgorithm() {
		System.out.println("Algorithms Supported in this JCE.");
        System.out.println("====================");
        // heading
        System.out.println("Provider: type.algorithm -> className" + "\n  aliases:" + "\n  attributes:\n");
        // discover providers
        Provider[] providers = Security.getProviders();
        for (Provider provider : providers) {
            System.out.println("<><><>" + provider + "<><><>\n");
            // discover services of each provider
            for (Provider.Service service : provider.getServices()) {
                System.out.println(service);
            }
            System.out.println();
        }
	}
	
	public static void main(String[] args) {
		CryptoGenerator m = new CryptoGenerator(CryptoGenerator.CryptoType.MD5);
		try {
			System.out.println(m.generateFileValue("/Users/ewu/test/1.json"));
			System.out.println(m.generateValue("1234"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
