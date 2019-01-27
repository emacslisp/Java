package com.dw.lib.test;

import java.io.File;
import java.io.IOException;

import com.dw.lib.EnvironmentHelper;
import com.dw.lib.FileUtils;

public class CopyFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileUtils fileUtils = new FileUtils();
		String filePath = EnvironmentHelper.getHomeDir() + "/test/copyFileTest";
		String targetFilePath = EnvironmentHelper.getHomeDir() + "/test/copyFileTest2";
		
		try {
			fileUtils.copyFolderUsingStream(new File(filePath), new File(fileUtils.normalizePath(targetFilePath)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
