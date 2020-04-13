package com.dw.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommandLineUtil {
	
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(runCommand("java -version"));
		//System.out.println("test");
	}
	
	public static String runCommand(String input) {
		String result="";
		
		try {
	        Process pr = Runtime.getRuntime().exec(input);
	        BufferedReader read = new BufferedReader(new InputStreamReader(pr.getInputStream()));
	        String str = read.readLine();
	        while (str != null){
	            System.out.println(str);
	            str = read.readLine();
	            result += str;
	            result += "\n";
	        }
	        
	        InputStream error = pr.getErrorStream();
	        InputStreamReader isrerror = new InputStreamReader(error);
	        BufferedReader bre = new BufferedReader(isrerror);
	        while ((str = bre.readLine()) != null) {
	        	result += str;
	            result += "\n";
	        }
	        
	        result += "exit value is " + pr.exitValue();
	        
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		
		return result;
	}
}
