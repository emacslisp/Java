package com.dw.leetcode;

public class Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers_5307 {

    public int[] getNoZeroIntegers(int n) {
        int[] result = new int[2];
        if(n<10) {
        	result[0] = 1;
        	result[1] = n-1;
        	return result;
        }
        int p = n;
        int counter = 0;
        int x = 0;
        while(p >= 10) {
        	int t = p%10;
        	
        	if(t == 0)
        	{
        		x += Math.pow(10, counter);
        	}
        	else if(t == 9) {
        		x += 7 * Math.pow(10, counter);
        	}
        	else if(t == 1) {
        		x += 2 * Math.pow(10, counter);
        	}
        	else {
        		x += (t + 1) * Math.pow(10, counter);
        	}
        	
        	p = p/10;
        	counter++;
        }
        
        result[0] = x;
        result[1] = n-x;
        
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers_5307 s = new Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers_5307();
		
		int[] results = s.getNoZeroIntegers(392);
		
		System.out.println(results[0]);
		System.out.println(results[1]);
	}

}
