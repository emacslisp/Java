package com.dw.lib.cli;

import java.io.File;

import com.dw.lib.FileUtils;

public class MKDirCLI {
	
	public static void help() {
		String[] helpInfo = { "jmkdir <path>" };

		for (String s : helpInfo) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		try {
			
			if (args.length != 1) {
				help();
				return;
			}
			
			FileUtils fileUtils = new FileUtils();

			String filePath = fileUtils.normalizePath(args[0]);
			
			File target = new File(filePath);
			
			if(!target.exists()) {
				target.mkdirs();
			} else {
				System.out.println("Folder " + args[0] + " is existed");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
