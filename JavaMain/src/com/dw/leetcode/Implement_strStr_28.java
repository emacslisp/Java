package com.dw.leetcode;

public class Implement_strStr_28 {
	
	public static int strStr(String haystack, String needle) {
		if(needle.length() == 0) return 0;
		
		if(needle.length()>haystack.length()) return -1;
		
		if(needle.length() == haystack.length()) {
			for(int i=0;i<haystack.length();i++) {
				if(haystack.charAt(i) != needle.charAt(i)) {
					return -1;
				}
			}
			
			return 0;
		}
		
		
        int[] offset = new int[needle.length()];
        offset[0]=1;
        boolean isSame = false;
        int same = 0;
		for(int i=1;i<needle.length();i++) {
			if( !isSame) {
				if(needle.charAt(i) != needle.charAt(0))
					offset[i]=i;
				else {
					isSame = true;
					offset[i]=i;
					same = i;
				}
			}
			else {
				offset[i] = same;
			}
		}
		
		int inc = 1;
		
		for(int i=0;i<=haystack.length()-needle.length();i+=inc) {
			int start = i;
			boolean match = true;
			for(int j=0;j<needle.length();j++) {
				if(haystack.charAt(start++) != needle.charAt(j)) {
					match = false;
					inc = offset[j];
					break;
				}
			}
			
			if(match)
				return i;
		}
		
		return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("mississippi","pi"));
	}

}
