package com.dw.leetcode;

//@example: Leetcode - 125. Valid Palindrome - https://leetcode.com/problems/valid-palindrome/#/description
public class Valid_Palindrome_125 {
	
	public boolean isPalindrome(String s) {
        boolean result = true;
        
        if(s.length() == 0 || s.length() == 1) return result;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++) {
        	if(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
        		sb.append(Character.toLowerCase(s.charAt(i)));
        	}
        }
        String pa = sb.toString();
        if(pa.length() == 0 || pa.length() == 1) return result;
        
        for(int i=0;i<=pa.length()/2;i++) {
        	if(pa.charAt(i) != pa.charAt(pa.length() - 1 - i)) {
        		result = false;
        		break;
        	}
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Valid_Palindrome_125 s= new Valid_Palindrome_125();
		
		System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
		//"race a car"
		System.out.println(s.isPalindrome("0P"));
	}

}
