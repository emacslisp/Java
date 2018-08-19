package com.dw.lib.test;

import com.dw.lib.MD5Generator;

public class MD5StringCLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 1) {
			System.out.println("md5str <file path>");
			return;
		}
		
		try {
			MD5Generator m = new MD5Generator();
			if(args.length == 1) {
				System.out.println(m.generateValue(args[0]));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
