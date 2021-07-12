package com.dw.lib.cli;

import java.io.IOException;

import com.dw.lib.FileUtils;

public class RMCLI {

	public static void main(String[] args) {
		if (args.length == 0) {
			String[] helpInfo = { "jrm <file list>" };

			for (String s : helpInfo) {
				System.out.println(s);
			}

			return;
		}

		FileUtils fileUtils = new FileUtils();
		for (String fileName : args) {
			try {

				boolean result = fileUtils.deleteFolderAndFile(fileName);
				if (!result) {
					if(fileUtils.isExisted(fileName))
						System.out.println("Failed to delete file: " + fileName);
					else 
						System.out.println(fileName + " is not existed");
				} else {
					System.out.println("Delete " + fileName + " successfully");
				}

			} catch (IOException e) {
				System.out.println("Delete " + fileName + " failed");
			}
		}
	}
}
