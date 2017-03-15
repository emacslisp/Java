package com.dw.leetcode;

public class Detect_Capital_520 {
	
	public static boolean isLowCase(char a){
		return a-'a' >= 0 && a-'a'<=26;
	}
	
	public static boolean isCapitalCase(char a){
		return a-'A' >= 0 && a-'A'<=26;
	}
	
	public static boolean detectCapitalUse(String word) {
        boolean result = true;
        
        char a = word.charAt(0);
        
        if(isLowCase(a)) {
        	for(int i=0;i<word.length();i++) {
        		if(!isLowCase(word.charAt(i))) {
        			result = false;
        			break;
        		}
        	}
        }
        else {
        	if(word.length() > 1) {
        		char b = word.charAt(1);
        		
        		if(isLowCase(b)){
        			for(int i=2;i<word.length();i++) {
                		if(!isLowCase(word.charAt(i))) {
                			result = false;
                			break;
                		}
                	}
        		}
        		else {
        			for(int i=2;i<word.length();i++) {
                		if(isLowCase(word.charAt(i))) {
                			result = false;
                			break;
                		}
                	}
        		}
        		
        	}
        }
        
        return result;
    }

	public static void main(String[] args) {
		String test = "USA";
		System.out.println(detectCapitalUse(test));
	}

}
