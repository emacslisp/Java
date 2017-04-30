package com.dw.googlecodejam;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class googlecodejam_2017_Round1_C1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
        FileInputStream instream = null;
        PrintStream outstream = null;
        
        try{
            instream = new FileInputStream("D:/test/0.txt");
            outstream = new PrintStream("D:/test/0.out");
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
        	System.out.print(String.format("Case #%d: ",(i+1)));
        	
        }
	}
}
