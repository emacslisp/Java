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

		String filePath = args[0];
		String targetFilePath = args[1];

		FileUtils fileUtils = new FileUtils();

		if (!fileUtils.isExisted(filePath)) {
			System.out.println("copy file is not existed");
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
