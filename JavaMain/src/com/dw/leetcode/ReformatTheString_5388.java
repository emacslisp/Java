package com.dw.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReformatTheString_5388 {
    public String reformat(String s) {
        List<Character> letter = new ArrayList<Character>();
        
        List<Character> digit = new ArrayList<Character>();
        
        for(int i=0;i<s.length();i++) {
        	char c= s.charAt(i);
        	
        	if(c-'a' >=0 && c-'z'<=0) {
        		letter.add(c);
        	}
        	
        	if(c-'0'>=0 && c-'9' <=0) {
        		digit.add(c);
        	}
        }
        
        if(Math.abs(letter.size() - digit.size()) <=1) {
        	
        	StringBuilder result = new StringBuilder();
        	
        	if(letter.size() - digit.size() == 0) {
        		for(int k=0;k<letter.size();k++) {
        			result.append(letter.get(k));
        			result.append(digit.get(k));
        		}
        		
        		return result.toString();
        	}
        	
        	if(letter.size() - digit.size() == 1) {
        		for(int k=0;k<digit.size();k++) {
        			result.append(letter.get(k));
        			result.append(digit.get(k));
        		}
        		
        		result.append(letter.get(letter.size() - 1));
        		
        		return result.toString();
        	}
        	
        	if(letter.size() - digit.size() == -1) {
        		for(int k=0;k<letter.size();k++) {
        			result.append(digit.get(k));
        			result.append(letter.get(k));
        		}
        		
        		result.append(digit.get(digit.size() - 1));
        		
        		return result.toString();
        	}
        	
        }
        
        return "";
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		ReformatTheString_5388 r = new ReformatTheString_5388();
		
		System.out.println(r.reformat(s));
	}

}
