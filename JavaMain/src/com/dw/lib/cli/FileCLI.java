package com.dw.lib.cli;

import java.io.File;

import com.dw.lib.BasicAuthentication;
import com.dw.lib.FileUtils;

public class FileCLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(args.length != 1) {
			System.out.println("jfile <arg1>");
			return;
		}
		
		try {
			FileUtils fileUtils = new FileUtils();
			String result = fileUtils.fileAttributes(args[0]);
			System.out.println(result);
			
			File file = new File(args[0]);
			System.out.println( "exists:"  + file.exists() );
	        System.out.println( "is file:"  + file.isFile() );
	        System.out.println( "can read:" + file.canRead() );
	        System.out.println( "can execute:" + file.canExecute() );
	        System.out.println( "can write:" + file.canWrite() );
	        System.out.println( "is hidden:" + file.isHidden() );
	        System.out.println( "file size: " + file.length());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
