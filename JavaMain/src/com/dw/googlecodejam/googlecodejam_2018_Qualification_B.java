package com.dw.googlecodejam;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class googlecodejam_2018_Qualification_B {

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
        int L[]= new int[100001];
        
        for(int i=0;i<T;i++) {
        	System.out.print(String.format("Case #%d: ",(i+1)));
        	
        	
        	String line = in.nextLine();
        	
        	int N = Integer.parseInt(line);
        	
        	line = in.nextLine();
        	
        	String[] temp = line.split(" ");
        	
        	for(int k=0;k<L.length;k++) {
        		L[k] = 0;
        	}
        	
        	for(int k=0;k<N;k++) {
        		L[k]=Integer.parseInt(temp[k]);
        	}
        	
			boolean done = false;
			while (!done) {
				done = true;
				for (int k = 0; k < N - 2; k++) {
					if (L[k] > L[k + 2]) {
						done = false;
						int tVar = L[k];
						L[k] = L[k+2];
						L[k+2] = tVar;
						
					}
				}
			}
			
			boolean flag = true;
			for(int k=0;k<N - 1;k++) {
				if(L[k]>L[k+1]) {
					System.out.println(k);
					flag = false;
					break;
				}
			}
			
        	if(flag)
        		System.out.println("OK");
        }
		
	}

}
