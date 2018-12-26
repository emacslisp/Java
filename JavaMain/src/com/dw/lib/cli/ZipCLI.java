package com.dw.lib.cli;

import java.io.File;
import java.io.IOException;

import com.dw.lib.FileUtils;
import com.dw.lib.ZipUtils;

public class ZipCLI {
	
	public static void usage() {
		String[] helpInfo = {
				"jZip a folder or a file into zip file",
				"jZip [-d] <source folder> <output zip file>",
				"for '.' by default it compress without parent folder name",
				"-d 	compress whole folder or compress all files/folders under the source folder"
		};
		
		for(String s: helpInfo) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		try {
			if(args.length != 2) {
				usage();
				return;
			}
			ZipUtils appZip = new ZipUtils();
			FileUtils fileUtils = new FileUtils();
			boolean isDot = false;
			if(args[0].equals(".")) {
				isDot = true;
			}
			
			if(args[0].equals("-d")) {
				isDot = true;
			}
			
			appZip.zipIt(new File(fileUtils.normalizePath(args[0])), new File(args[1]), isDot);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
