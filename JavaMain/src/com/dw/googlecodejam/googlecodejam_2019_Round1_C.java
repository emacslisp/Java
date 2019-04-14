package com.dw.googlecodejam;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class googlecodejam_2019_Round1_C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  FileInputStream instream = null;
	        PrintStream outstream = null;
	        
	        try{
	            instream = new FileInputStream("/Users/ewu/test/1.txt");
	            outstream = new PrintStream("/Users/ewu/test/1.out");
	            System.setIn(instream);
	            System.setOut(outstream);
	        }
	        catch(Exception e){
	            System.err.println("Error Occurred");
	        }
	        
	        Scanner in = new Scanner(System.in);
	        String strT = in.nextLine();
	        int T = Integer.parseInt(strT);
	        
	        for(int i=0;i<T;i++) {
	        	
	        }

	}

}
