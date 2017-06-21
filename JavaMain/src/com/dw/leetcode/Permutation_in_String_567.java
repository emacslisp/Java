package com.dw.leetcode;

import java.util.ArrayList;

public class Permutation_in_String_567 {

	
	public static boolean checkInclusion(String s1, String s2) {

		boolean result = false;

		int[] hash = new int[26];
		
		for(int i=0;i<s1.length();i++)
			hash[s1.charAt(i) - 'a']++;
		
		int start=0;
		for(int i=0;i<s2.length();i++) {
			hash[s2.charAt(i)-'a']--;
			
			while(hash[s2.charAt(i)-'a'] < 0) {
				hash[s2.charAt(start)-'a']++;
				start++;
			}
			
			if((i-start) == (s1.length() - 1))
				return true;
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// s1 = "ab" s2 = "eidbaooo"

		System.out.println(checkInclusion("abc", "ccccbbbbaaaa"));
	}

}
