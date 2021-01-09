package com.dw.algorithmlib;

public class StringAlgorithm {
	
	public boolean isPalindrom(String s) {
		boolean result = true;
		if (s.length() == 0 || s.length() == 1)
			return result;

		for (int i = 0; i <= s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	public boolean isPalindromWithDigitalAndChar(String s) {
		boolean result = true;
		
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
	
	public String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
