package com.dw.leetcode;

public class BreakaPalindrome_1328 {
    public String breakPalindrome(String palindrome) {
    	int size = palindrome.length();
    	if(size == 1) return "";
    	char[] c = palindrome.toCharArray();
    	for(int i=0;i<size/2;i++) {
    		if(c[i] != 'a') {
    			c[i] = 'a';
    			return new String(c);
    		}
    	}
    	
    	c[size - 1] = 'b';
    	return new String(c);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BreakaPalindrome_1328 s = new BreakaPalindrome_1328();
		String input = "abccba";
		String result = s.breakPalindrome(input);
		System.out.println(result);
	}

}
