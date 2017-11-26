package com.dw.leetcode;

public class PalindromeNumber_9 {

    public boolean isPalindrome(int x) {
    	long y = x;
    	if(y<0) return false;
        if(y<10) return true;
        
        String s = "" +y;
        
        int low = 0;
        int high = s.length() - 1;
        
        while(high>low) {
        	if(s.charAt(low) == s.charAt(high)) {
        		low++;
        		high--;
        	}
        	else
        		return false;
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeNumber_9 s = new PalindromeNumber_9();
		
		System.out.println(s.isPalindrome(-2147483648));
	}

}
