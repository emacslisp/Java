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
            instream = new FileInputStream("D:/test/1.txt");
            outstream = new PrintStream("D:/test/1.out");
            System.setIn(instream);
            System.setOut(outstream);
        }
        catch(Exception e){
            System.err.println("Error Occurred");
        }
        
        int arraySize = 3000;
        int array[] = new int[arraySize];

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < arraySize; j++) {
				array[j] = 0;
			}
			int T = in.nextInt();

			int temp;
			for (int m = 0; m < 2 * T - 1; m++) {
				for (int n = 0; n < T; n++) {
					temp = in.nextInt();
					array[temp]++;
				}
			}
			
			System.out.print(String.format("Case #%d: ",(i+1)));
			 
			  for(int m=0;m<3000;m++)
			  {
				  if(array[m]>0 && array[m]%2==1)
				  {
					  System.out.print(String.format("%d ", m));
				  }
			  }
			  System.out.println();

		}

	}

}
