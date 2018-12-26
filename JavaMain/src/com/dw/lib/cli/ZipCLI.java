package com.dw.lib.cli;

import java.io.File;
import java.io.IOException;

import com.dw.lib.FileUtils;
import com.dw.lib.ZipUtils;

public class ZipCLI {
	
	public static void usage() {
		String[] helpInfo = {
				"jZip a folder or a file into zip file",
				"jZip <source folder> <output zip file>"
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
			appZip.zipIt(new File(fileUtils.normalizePath(args[0])), new File(args[1]));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
