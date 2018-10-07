package com.dw.lib.cli;

import com.dw.lib.CryptoGenerator;
import com.dw.lib.NetUtils;

public class MD5FileCLI {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("md5file <file path>");
			return;
		}
		
		try {
			CryptoGenerator m = new CryptoGenerator();
			if(args.length == 1) 
				System.out.println(m.generateFileValue(args[0]));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
