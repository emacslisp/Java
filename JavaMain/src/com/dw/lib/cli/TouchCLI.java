package com.dw.lib.cli;

import com.dw.lib.FileUtils;

public class TouchCLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 0) {
			String[] helpInfo = {"jtouch <file list>"};
			
			for(String s : helpInfo) {
				System.out.println(s);
			}

			return;
		}
		
		FileUtils fileUtils = new FileUtils();
		
		for(String fileName : args) {
			boolean result = fileUtils.createEmptyFile(fileName);
			if(!result) {
				System.out.println("Failed to create file: " + fileName);
			}
		}
	}

}
