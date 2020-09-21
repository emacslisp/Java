package com.dw.leetcode;

public class StrongPasswordChecker_420 {
	public int strongPasswordChecker(String s) {
        int result = 0;
        
        if(s.length() < 6)
        	result += 6 - s.length();
        
        if(s.length() > 20)
        	result += s.length() - 20;
        
        boolean hasUpperCase = false;
        boolean hasDigital = false;
        boolean hasLowerCase = false;
        
        for (int i=0;i<s.length();i++) {
        	char c = s.charAt(i);
        	
        	if(c-'A' >=0 && c-'Z'<=0) {
        		hasUpperCase = true;
        	}
        	
        	if(c-'a' >= 0 && c-'z'<=0) {
        		hasLowerCase = true;
        	}
        	
        	if(c-'0' >=0 && c-'9'<=0) {
        		hasDigital = true;
        	}
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
