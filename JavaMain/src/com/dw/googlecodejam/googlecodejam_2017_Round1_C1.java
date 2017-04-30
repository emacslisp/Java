package com.dw.googlecodejam;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Scanner;

public class googlecodejam_2017_Round1_C1 {
	public static class s {
		public int R;
		public int H;
		public long area = 0;
		public s(int R,int H){
			this.R = R;
			this.H = H;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
        	
        	strT = in.nextLine();
        	String[] temp = strT.split(" ");
        	int N = Integer.parseInt(temp[0]);
        	int K = Integer.parseInt(temp[1]);
        	s[] array = new s[N];
        	
        	s[] array2 = new s[N];
        	
        	for(int j=0;j<N;j++) {
        		strT = in.nextLine();
        		temp = strT.split(" ");
        		int R = Integer.parseInt(temp[0]);
        		int H = Integer.parseInt(temp[1]);
        		array[j] = new s(R,H);
        		array[j].area = ((long)R)*((long)H);
        		
        		array2[j] = new s(R,H);
        		array2[j].area = ((long)R)*((long)H);
        	}
        	
    		Comparator<s> comparator = new Comparator<s>() {
    			@Override
    			public int compare(s str1, s str2) {
    				if (str1.area > str2.area)
    					return -1;
    				if (str1.area < str2.area)
    					return 1;
    				return 0;
    			}
    		};
    		
    		Comparator<s> comparator2 = new Comparator<s>() {
    			@Override
    			public int compare(s str1, s str2) {
    				if (str1.R > str2.R)
    					return -1;
    				if (str1.R < str2.R)
    					return 1;
    				return 0;
    			}
    		};

    		Arrays.sort(array, comparator);
    		Arrays.sort(array2, comparator2);
    		
    		long finalResult = 0;
    		long result = 0;
    		long base = 0;
    		for(int m=0;m<K;m++)
    		{
    			result += array[m].area;
    			if(array[m].R > base)
    				base = array[m].R;
    		}
    		
    		finalResult = base*base + 2* result;

        	for(int k=0;k<K;k++)
        	{
        		//array2[k].R
        		boolean flag = true;
        		for(int m=0;m<K;m++)
        		{
        			if(array[m].R == array2[k].R){
        				flag = false;
        				break;
        			}
        		}
        		
        		if(flag) {
        			long tempResult = (result - array[K-1].area + array2[k].area);
        			long tempBase = base > array2[k].R ? base: array2[k].R;
        			long tempMax = tempBase*tempBase + 2* tempResult;
        			if(finalResult < tempMax) {
	        			finalResult = tempMax;
	        		}
        		}
        	}
        	DecimalFormat df = new DecimalFormat("#.000000000");
        	
        	//System.out.println(df.format(finalResult));
        	System.out.println(df.format((new BigDecimal(finalResult)).multiply(new BigDecimal(Math.PI))));
        }
	}
}
