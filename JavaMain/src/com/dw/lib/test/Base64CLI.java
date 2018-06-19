package com.dw.lib.test;
import com.dw.lib.BasicAuthentication;

public class Base64CLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length == 0) {
			System.out.println("Base arg1 arg2 ...");
			System.out.println("output: ");
			System.out.println("  <arg1_base64_hash>");
			System.out.println("  <arg2_base64_hash>");
			System.out.println("...");
		}
		
		for(String s: args) {
			System.out.println(BasicAuthentication.base64Generator(s));
		}
	}
}
