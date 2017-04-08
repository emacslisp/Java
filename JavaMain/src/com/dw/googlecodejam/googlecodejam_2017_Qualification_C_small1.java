package com.dw.googlecodejam;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class googlecodejam_2017_Qualification_C_small1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        FileInputStream instream = null;
        PrintStream outstream = null;
        
        try{
            instream = new FileInputStream("D:/test/3.txt");
            outstream = new PrintStream("D:/test/3.out");
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
        	
        	long N = Long.parseLong(temp[0]);
        	long K = Long.parseLong(temp[1]);
        	
        	long t = log(K,2);
        	
        	long bound = (long) (Math.pow(2,t) - 1);
        	
        	long m = (N-bound)/(bound + 1);
        	
        	long rest = (N - ((bound + 1)*m + bound))>= (K-bound) ? m + 1:m;
        	
        	
        	long Ls = 0;
        	long Rs = 0;

    		Ls = (rest-1)/2;
    		Rs = (rest-1)/2 + (rest-1)%2;

        	
        	System.out.print(String.format("%d %d", Math.max(Ls, Rs), Math.min(Ls, Rs)));
        	System.out.println();
        }
		
        
	}

	static long log(long x, long base)
	{
	    return (long) (Math.log(x) / Math.log(base));
	}
}
