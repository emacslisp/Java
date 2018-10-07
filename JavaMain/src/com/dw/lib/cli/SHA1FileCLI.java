package com.dw.lib.cli;

import com.dw.lib.CryptoGenerator;

public class SHA1FileCLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length != 1) {
			System.out.println("sha1file <file path>");
			return;
		}
		
		try {
			CryptoGenerator m = new CryptoGenerator(CryptoGenerator.CryptoType.SHA_1);
			if(args.length == 1) 
				System.out.println(m.generateFileValue(args[0]));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
