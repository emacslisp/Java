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
        		int index = 0; 
        		
        		StringBuilder builder = new StringBuilder();
        		int mode = 0;
				for (int k = 1; k < line.length(); k++) {
						if (line.charAt(index) < line.charAt(k)) {
							index = k;
							continue;
						} else if (line.charAt(index) > line.charAt(k)) {
							mode = 1;
							break;
						} else if (line.charAt(index) == line.charAt(k)) {
							continue;
						}
				}
				
				if (mode == 1) {
					for (int k = 0; k < index; k++) {
						builder.append(line.charAt(k));
					}
					
					int start = (line.charAt(index) - '0') - 1;
					
					if(start > 0)
						builder.append(start);
					
					for (int k = index + 1; k < line.length(); k++) {
						builder.append("9");
					}
				}
				
				
        		System.out.println(mode == 0? line: builder.toString());
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
