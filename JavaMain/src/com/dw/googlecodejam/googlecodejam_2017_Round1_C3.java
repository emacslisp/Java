package com.dw.googlecodejam;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class googlecodejam_2017_Round1_C3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
        	
        	strT = in.nextLine();
        	String[] temp = strT.split(" ");
        	int N = Integer.parseInt(temp[0]);
        	int K = Integer.parseInt(temp[1]);
        	
        	strT = in.nextLine();
        	
        	double U = Double.parseDouble(strT);
        	
        	double[] p = new double[N];
        	strT = in.nextLine();
        	
        	temp = strT.split(" ");
        	
        	double total = U;
        	for(int j=0;j<N;j++) {
        		p[j] = Double.parseDouble(temp[j]);
        		total += p[j];
        	}
        	
        	double finalP = total/(double)N;
        	DecimalFormat df = new DecimalFormat("0.000000");
        	if(finalP >= 1 || Math.abs(finalP - 1) <= Math.pow(10,-6))
        	{
        		System.out.println(df.format(1));
        	}
        	else {
        		BigDecimal b = new BigDecimal(finalP);
        		System.out.println(df.format(b.pow(N)));
        	}
        }
	}
}
