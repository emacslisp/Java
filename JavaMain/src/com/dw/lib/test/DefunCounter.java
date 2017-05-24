package com.dw.lib.test;

import java.io.*;
import java.util.regex.Pattern;

public class DefunCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String FILENAME = "/Users/ewu/workspace/c/my-vps/main/lisp/lang/java-mode/java-snippet.el";
		try {
			
		BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		int counter = 0;
			String sCurrentLine;
	           Pattern pattern =
	                   Pattern.compile("\\(defun .*");

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				
				if(pattern.matcher(sCurrentLine).find())
					counter++;
				
			}
			System.out.println(counter);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
