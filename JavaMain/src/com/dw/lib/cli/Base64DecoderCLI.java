package com.dw.lib.cli;

import com.dw.lib.BasicAuthentication;

public class Base64DecoderCLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 0) {
			System.out.println("decode arg1 arg2 ...");
			System.out.println("output: ");
			System.out.println("  <arg1_base64_hash>");
			System.out.println("  <arg2_base64_hash>");
			System.out.println("...");
			return;
		}
		
		for(String s: args) {
			System.out.println(BasicAuthentication.base64Decode(s));
		}
	}

}
