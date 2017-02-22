package com.dw.googlecodejam;

import java.lang.*;
import java.util.*;
import java.io.*;

public class googlecodejam_2016_A1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        FileInputStream instream = null;
        PrintStream outstream = null;
        
        try{
            instream = new FileInputStream("/Users/ewu/1.txt");
            outstream = new PrintStream("/Users/ewu/1.out");
            System.setIn(instream);
            System.setOut(outstream);
        }
        catch(Exception e){
            System.err.println("Error Occurred");
        }

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for(;in.hasNext();){
            for(int j=0;j<T;j++){
            	
            	String wholeLine = in.nextLine();
            	String[] t = wholeLine.split(" ");
            	//Parse Integer.parse string to int or some other things to go
                //System.out.println(in.nextInt() + " " + in.nextInt());
            }
        }

        String[] strings = { "Hello ", "This ", "is", "Sorting", "Example" };
        Arrays.sort(strings);

        for(int j=0;j<strings.length;j++)
        System.out.println(strings[j]);

        System.err.println("done.");
        return;

	}

}
