package com.dw.lib.cli;

import java.io.File;
import java.io.IOException;

import com.dw.lib.FileUtils;

public class CopyFileCLI {

	public static void help() {
		String[] helpInfo = { "jcp <file> <target file>" };

		for (String s : helpInfo) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			help();
			return;
		}
		
		FileUtils fileUtils = new FileUtils();

		String filePath = fileUtils.normalizePath(args[0]);
		String targetFilePath = fileUtils.normalizePath(args[1]);

		if (!fileUtils.isExisted(filePath)) {
			System.out.println("copy file " + args[0] +" is not existed");
			return;
		}
		
		if(filePath.equals(targetFilePath)) {
			System.out.println(args[0] +" " + args[1] + " are same files");
			return;
		}
		
		try {
			fileUtils.copyFileUsingStream(new File(filePath), new File(targetFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
