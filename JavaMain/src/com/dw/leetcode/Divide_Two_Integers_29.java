package com.dw.leetcode;

public class Divide_Two_Integers_29 {
	
    public int divide(int dividend, int divisor) {
    	
    	int sign = 1;
    	if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
    		sign = -1;
    	long ldividend = Math.abs((long) dividend);
    	long ldivisor = Math.abs((long) divisor);
    	
    	long lans = ldivide(ldividend, ldivisor);
    	
    	int ans;
    	if (lans > Integer.MAX_VALUE){ //Handle overflow.
    		ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
    	} else {
    		ans = (int) (sign * lans);
    	}
    	return ans;
        
    }
    
    private long ldivide(long ldividend, long ldivisor) {
    	if (ldividend < ldivisor) return 0;
    	
    	long sum = ldivisor;
    	long m = 1;
    	int counter = 0;
    	while (true) {
    		long temp = sum <<counter;
    		
    		if(temp > ldividend) {
    			break;
    		}
    		
    		if(temp == ldividend)
    			return Integer.toUnsignedLong(1<<counter);
    		
    		counter++;
    	}
    	
    	return Integer.toUnsignedLong(1<<(counter - 1)) + ldivide(ldividend - (ldivisor<<(counter - 1)), ldivisor);
    }

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Divide_Two_Integers_29 s=new Divide_Two_Integers_29();
		System.out.println(s.divide(-2147483648
				,-1));
	}

}
