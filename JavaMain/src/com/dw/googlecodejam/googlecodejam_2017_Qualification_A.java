package com.dw.googlecodejam;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class googlecodejam_2017_Qualification_A {
	public static void main(String[] args) {
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
        	
        	
        	String line = in.nextLine();
        
        	String[] temp = line.split(" ");
        	
        	int size = Integer.parseInt(temp[1]);
        	int[] array = new int[temp[0].length()];
        	
        	
        	for(int k=0;k<temp[0].length();k++) {
        		if(temp[0].charAt(k) == '-')
        			array[k]=0;
        		else
        			array[k]=1;
        	}
        	int result = 0;
        	for(int k=0;k<=array.length-size;k++) {
        		if(array[k] == 0) {
        			for(int m=k;m<k+size;m++) {
        				array[m] = (array[m] + 1)%2;
        			}
        			
        			result++;
        		}
        	}
        	
        	boolean isFull = true;
        	
        	for(int k=0;k<array.length;k++) {
        		if(array[k] == 0) {
        			isFull = false;
        			break;
        		}
        	}
        	
        	if(isFull)
        		System.out.println(result);
        	else
        		System.out.println("IMPOSSIBLE");
        }
		

	}

	
}
