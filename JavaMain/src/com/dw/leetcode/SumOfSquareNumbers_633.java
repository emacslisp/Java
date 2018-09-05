package com.dw.leetcode;

public class SumOfSquareNumbers_633 {
    public boolean judgeSquareSum(int c) {
        
    	int end = (int)Math.sqrt(c/2);
    	
    	for(int i=0;i<=end;i++) {
    		if(isSquare(c - i*i)) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    public boolean isSquare(int n) {
    	int t = (int)Math.sqrt(n);
    	
    	return t*t == n;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumOfSquareNumbers_633 s = new SumOfSquareNumbers_633();
		System.out.println(s.judgeSquareSum(3));
	}
}
