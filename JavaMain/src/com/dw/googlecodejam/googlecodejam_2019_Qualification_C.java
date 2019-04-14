package com.dw.googlecodejam;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class googlecodejam_2019_Qualification_C {

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
        	String line = in.nextLine();
        	String[] temp = line.split(" ");
        	
        	int N = Integer.parseInt(temp[0]);
        	int L = Integer.parseInt(temp[1]);
        	
        	HashMap<BigInteger, Integer> hashMap = new HashMap<BigInteger, Integer>();
        	HashMap<BigInteger, Integer> hashMap2 = new HashMap<BigInteger, Integer>();
        	
        	BigInteger[] input = new BigInteger[L];
        	BigInteger[] output = new BigInteger[L+1];
        	BigInteger[] letter = new BigInteger[26];
        	
        	line = in.nextLine();
        	
        	temp = line.split(" ");
        	
        	Set<BigInteger> bigInterSet = new TreeSet<BigInteger>();
        	
        	for(int k=0;k<L;k++) {
        		input[k] = new BigInteger(temp[k]);
        	}
        	
            for(int j=0;j<L-1;j++) {
            	if(!input[j].equals(input[j+1])) {
	            	BigInteger t = input[j].gcd(input[j+1]);
	                output[j] = input[j].divide(t);
	                output[j+1] = t;
	                output[j+2] = input[j+1].divide(t);
	                
	                if(!hashMap.containsKey(output[j])) {
	                	bigInterSet.add(output[j]);
	                    hashMap.put(output[j], j);
	                }
	                
	                if(!hashMap.containsKey(output[j+1])) {
	                	bigInterSet.add(output[j+1]);
	                    hashMap.put(output[j+1], j+1);
	                }
	                
	                if(!hashMap.containsKey(output[j+2])) {
	                	bigInterSet.add(output[j+2]);
	                    hashMap.put(output[j+2], j+2);
	                }
            	}
            }
        	
            Iterator<BigInteger> iterator = bigInterSet.iterator(); 
            int index = 0;
            while (iterator.hasNext())  {
            	letter[index] = iterator.next();
            	hashMap2.put(letter[index], index);
            	index++;
            }
            
            for(int j=0;j<L-1;j++) {
            	if(input[j].equals(input[j+1])) {
            		for(int k=0;k<letter.length;k++) {
            			BigInteger b1 = letter[k];
            			
                    	if(input[j].mod(b1).equals(new BigInteger("0"))) {
                    		output[j] = input[j].divide(b1);
        	                output[j+1] = b1;
        	                output[j+2] = input[j+1].divide(b1);
        	                break;
                    	}
            		}
            	}
            }
          
            System.out.printf("Case #%d: ", i+1);
            for(int j=0;j<=L;j++) {
            	System.out.printf("%c", hashMap2.get(output[j])+'A');
            }
            System.out.println();
        }
	}

}
