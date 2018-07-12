package com.dw.leetcode;

import static org.hamcrest.CoreMatchers.containsString;

public class ToLowerCase_709 {
	
	public static String toLowerCase(String str) {
		String result ="";
        for(int i=0;i<str.length();i++) {
        	char c = str.charAt(i);
        	if (c >= 'A' && c<='Z') {
        		c = (char)((int)c - (int)'A' + (int)'a');
        	}
        	result += c;
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABCdEfG";
		System.out.println(toLowerCase(s));
	}

}
