package com.dw.lib.cli;

import com.dw.lib.GrepUtils;

public class JGrep {
	
	private static void printUsageAndExit() {
		System.out.println("jgrep <regex> <path>");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 2) {
			printUsageAndExit();
			return;
		}
		
		GrepUtils grepUtils = new GrepUtils();
		grepUtils.grep(args[1], args[0]);
		
	}

}
