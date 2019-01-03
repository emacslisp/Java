package com.dw.lib.test;

import java.io.File;
import java.io.IOException;

import com.dw.lib.FileUtils;

public class CopyFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileUtils fileUtils = new FileUtils();
		String filePath = "/Users/di.wu/test/1.json";
		String targetFilePath = "/Users/di.wu/test/100.json";
		try {
			fileUtils.copyFileUsingStream(new File(filePath), new File(targetFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
