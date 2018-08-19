package com.dw.lib.test;

import com.dw.lib.MD5Generator;
import com.dw.lib.NetUtils;

public class MD5FileCLI {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("md5file <file path>");
			return;
		}
		
		try {
			MD5Generator m = new MD5Generator();
			if(args.length == 1) 
				System.out.println(m.generateFileValue(args[0]));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
