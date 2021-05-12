package com.dw.leetcode;

public class RepeatedSubstringPattern_459 {

	public boolean repeatedSubstringPattern(String s) {
		
		 String str=s+s;
		    String temp =str.substring(1,str.length()-1);
		    if(temp.contains(s)) return true;
		    return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatedSubstringPattern_459 s = new RepeatedSubstringPattern_459();
		String x = "abab";
		boolean result = s.repeatedSubstringPattern(x);
		System.out.println(result);
	}

}
