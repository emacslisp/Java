package com.dw.leetcode;

public class ConcatenationofConsecutiveBinaryNumbers_5620 {
	
	public int concatenatedBinary(int n) {
		StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++) {
        	sb.append(Integer.toBinaryString(i));
        }
        
        long base = 1;
        long value = 0;
        String s = sb.toString();
        for(int i=s.length() - 1; i>=0;i--) {
        	char c = s.charAt(i);
        	if(c=='1') {
        		value += base;
        	}
        	
        	base *= 2;
        	if(value > 1000000007L)
        		value %= 1000000007L;
        	
        	if(base > 1000000007L)
        	base %= 1000000007L;
        }

        return (int) (value);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcatenationofConsecutiveBinaryNumbers_5620 s = new ConcatenationofConsecutiveBinaryNumbers_5620();
		int result = s.concatenatedBinary(1000000);
		System.out.println(result);
	}

}
