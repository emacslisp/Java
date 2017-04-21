package com.dw.yacc;

import java.io.File;
import java.io.IOException;

public class OpenFile {
	public File temp;
	
	public OpenFile() {
		try {
			temp = File.createTempFile("temp",".txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void create_file_name() {
		
	}
	
	public void OpenTempFile() {
		try {
			temp = File.createTempFile("temp",".txt");
			
			//cleaning when program exit
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeTempFile() {
		temp.deleteOnExit();
	}
}
