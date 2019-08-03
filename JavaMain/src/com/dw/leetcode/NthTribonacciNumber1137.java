package com.dw.leetcode;

public class NthTribonacciNumber1137 {
	
	public static int tribonacci(int n) {
		long[] anArray = new long[100];
		for(int i=0;i<=n;i++) {
			anArray[i] = 0;
		}
		anArray[0] = 0;
		anArray[1] = 1;
		anArray[2] = 1;
		
		if(n<=2) {
			return (int)anArray[n];
		}
		
		for(int i=3;i<=n;i++) {
			anArray[i] = anArray[i-1] + anArray[i-2] + anArray[i-3];
		}
		
		return (int)anArray[n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<=37;i++) {
			System.out.println(i + " " + tribonacci(i));
		}
	}

}
