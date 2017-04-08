package com.dw.googlecodejam;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class googlecodejam_2017_B {

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
        


        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for(int i=0;i<T;i++) {
        	System.out.print(String.format("Case #%d: ",(i+1)));
        	
        	
        	int line = in.nextInt();
        
        	
        	
        	System.out.print(foo(line));
        	System.out.println();
        }
		

	}

	public static int foo(int num)
	{
		if(num<10) return num;
		
		for(int i = num;i>=0;i--)
		{
			if(isIncreate(i))
				return i;
		}
		
		return 0;
	}
	
	public static boolean isIncreate(int n) {
		int first = n % 10;
		n = n / 10;
		while (n > 0) {
			int temp = n % 10;
			n = n / 10;
			if (temp > first)
				return false;
			else
				first = temp;
		}
		return true;
	}

}
