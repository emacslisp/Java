package com.dw.googlecodejam;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class googlecodejam_2019_Qualification_C {

	static int gcd(int a, int b) 
	{ 
	  if (a == 0) 
	    return b;

	  return gcd(b % a, a); 
	} 

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
        
        try {
        Scanner in = new Scanner(System.in);
        String strT = in.nextLine();
        int T = Integer.parseInt(strT);
        
        for(int i=0;i<T;i++) {
        	String line = in.nextLine();
        	String[] temp = line.split(" ");
        	
        	int N = Integer.parseInt(temp[0]);
        	int L = Integer.parseInt(temp[1]);
        	
        	HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        	HashMap<Integer, Integer> hashMap2 = new HashMap<Integer, Integer>();
        	
        	int[] input = new int[L];
        	int[] output = new int[L+1];
        	int[] letter = new int[26];
        	
        	line = in.nextLine();
        	
        	temp = line.split(" ");
        	
        	for(int k=0;k<L;k++) {
        		input[k] = Integer.parseInt(temp[k]);
        	}
        	
            for(int j=0;j<L-1;j++) {
                int t = gcd(input[j], input[j+1]);
                output[j] = input[j]/t;
                output[j+1] = t;
                output[j+2] = input[j+1]/t;
            }
        	
            int letterIndex = 0;
            for(int j=0;j<L+1;j++) {
              if(!hashMap.containsKey(output[j])) {
                letter[letterIndex++] = output[j];
                hashMap.put(output[j], j);      
              }
            }

            Arrays.sort(letter);
            
            for(int j=0;j<letterIndex;j++) {
                hashMap2.put(letter[j],j);
            }
            
            System.out.printf("Case #%d: ", i+1);
            for(int j=0;j<=L;j++) {
            	System.out.printf("%c", hashMap2.get(output[j])+'A');
            }
            System.out.println();

        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
	}

}
