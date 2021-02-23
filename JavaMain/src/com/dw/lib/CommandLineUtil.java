package com.dw.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class CommandLineUtil {
	
	public class Report {
		public String output;
		public int exitValue;
		public Report() {
			
		}
		
		public Report(String output, int exitValue) {
			this.output = output;
			this.exitValue = exitValue;
		}
	}
	
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
	
	public Report runCommand(String input, long timeout, File dir) throws InterruptedException {
		String result="";
		
		try {
	        Process pr = Runtime.getRuntime().exec(input, null, dir);
	        if(!pr.waitFor(timeout, TimeUnit.SECONDS)) {
	        	pr.destroy();
	        	return new Report("time out", 1);
	        }
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
	        
	        return new Report(result, 0);

	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		
		return new Report(result, 1);
	}
}
