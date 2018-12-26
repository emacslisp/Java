package com.dw.lib.cli;

import java.io.File;

import com.dw.lib.FileUtils;
import com.dw.lib.ZipUtils;

public class UnzipCLI {
	
	public static void usage() {
		String[] helpInfo = {
				"junzip a folder or a file into zip file",
				"junzip <zip file> <output folder>"
		};
		
		for(String s: helpInfo) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			if(args.length == 0 || args.length > 2) {
				usage();
				return;
			}
			ZipUtils appZip = new ZipUtils();
			FileUtils fileUtils = new FileUtils();
			String outputFolder = ".";
			if(args.length == 1) {
				outputFolder = fileUtils.normalizePath(".");
			}
			else {
				outputFolder = fileUtils.normalizePath(args[1]);
			}
			
			appZip.unzipIt(args[0], outputFolder);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
