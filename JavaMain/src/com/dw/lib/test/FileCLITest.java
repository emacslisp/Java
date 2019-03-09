package com.dw.lib.test;

import java.io.File;
import java.io.IOException;

import com.dw.lib.FileUtils;

public class FileCLITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileUtils fileUtils = new FileUtils();
		try {
			String path = "/Users/ewu/test/1.html";
			
			File file = new File(path);
			System.out.println( "exists:"  + file.exists() );
	        System.out.println( "is file:"  + file.isFile() );
	        System.out.println( "can read:" + file.canRead() );
	        System.out.println( "can execute:" + file.canExecute() );
	        System.out.println( "can write:" + file.canWrite() );
	        System.out.println( "is hidden:" + file.isHidden() );
	        System.out.println("");
	        
			String result = fileUtils.fileAttributes(path);
			System.out.println(result);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
