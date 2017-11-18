package com.dw.leetcode;

public class ValidPerfectSquare_367 {
	
	public static boolean isPerfectSquare(int num) {
		if(num<0) return false;
		if(num == 0 || num == 1) return true;
        boolean result = false;
        
        long low = 2;
        long high = num;
        
        while(high > low) {
        	
        	long mid = (high + low)/(long)2;
        	
        	if(mid*mid<num) {
        		low = mid + 1;
        	}
        	
        	if(mid * mid == num) {
        		result = true;
        		break;
        	}
        	
        	if(mid * mid > num) {
        		high = mid - 1;
        	}
        }
        
        if(low == high && low*low == num) {
        	result = true;
        }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPerfectSquare(2147483647));
	}

}
