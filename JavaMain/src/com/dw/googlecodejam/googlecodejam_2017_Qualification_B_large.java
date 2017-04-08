package com.dw.googlecodejam;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class googlecodejam_2017_Qualification_B_large {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        FileInputStream instream = null;
        PrintStream outstream = null;
        
        try{
            instream = new FileInputStream("D:/test/2.txt");
            outstream = new PrintStream("D:/test/2.out");
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
        
        	if(line.length()<4) {
	        	System.out.print(foo(Integer.parseInt(line)));
	        	System.out.println();
        	}
        	else
        	{
        		String output = "";
        		for(int k=0;k<line.length()-2;k++){
        			output+="9";
        		}
        		StringBuilder builder = new StringBuilder();
        		builder.append(line.charAt(0)).append(line.charAt(1));
        		int start = Integer.parseInt(builder.toString());
        		start = foo(start - 1);
        		
        		System.out.print(start);
        		System.out.print(output);
        		System.out.println();
        	}
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
