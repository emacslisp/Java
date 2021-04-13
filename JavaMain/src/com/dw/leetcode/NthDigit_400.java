package com.dw.leetcode;

public class NthDigit_400 {

	public int findNthDigit(int n) {
		long start = 1;
		long base = 1;
		
		while (n >= 9*base*start) {
			n -= 9*base*start;
			base *= 10;
			start++;
		}
		
		long t = base + n/start - 1;
		if(n%start == 0) return (int)t%10;
		
		
		long t1 = t + 1;
		
		return (int) (t1/Math.pow(10, start - n%start))% 10;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NthDigit_400 s = new NthDigit_400();
		System.out.println(s.findNthDigit(1111));
	}

}
