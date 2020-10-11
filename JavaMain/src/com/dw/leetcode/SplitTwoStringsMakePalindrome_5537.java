package com.dw.leetcode;

public class SplitTwoStringsMakePalindrome_5537 {
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
	
	public boolean checkPalindromeFormation(String a, String b) {
		if(a.length() == 1 && b.length() == 1) return true;
		
        for(int i=0;i<a.length();i++) {
        	if(a.charAt(i) == b.charAt(a.length() - 1 - i)) {
        		continue;
        	}
        	else {

        			if(isPalindrome(a.substring(i, a.length() -i)) || isPalindrome(b.substring(i, a.length() -i))) {
        				System.out.println(i);
        				return true;
        			}
        			else 
        				break;

        	}
        }
        
        for(int i=0;i<b.length();i++) {
        	if(b.charAt(i) == a.charAt(b.length() - 1 - i)) {
        		continue;
        	}
        	else {

        			if(isPalindrome(a.substring(i, b.length() -i)) || isPalindrome(b.substring(i, b.length() -i))) {
        				System.out.println(i);
        				return true;
        			}
        			else 
        				break;

        	}
        	
        }
        
        return false;
    }
	
	public boolean checkPalindromeFormation2(String a, String b) {
		if(a.length() == 1 && b.length() == 1) return true;
		
        for(int i=0;i<a.length();i++) {
        	String aPrefix = a.substring(0,i);
        	String aSuffix = a.substring(i,a.length());
        	
        	String bPrefix = b.substring(0,i);
        	String bSuffix = b.substring(i,a.length());
        	
        	if(isPalindrome(aPrefix + bSuffix) || isPalindrome(bPrefix + aSuffix)) {
        		System.out.println(i);
        		return true;
        	}
        }

        
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplitTwoStringsMakePalindrome_5537 s = new SplitTwoStringsMakePalindrome_5537();
		String a = "aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd";
		String b = "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea";
		boolean result = s.checkPalindromeFormation2(a, b);
		System.out.println(result);
	}

}
