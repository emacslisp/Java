package com.dw.leetcode;

public class ReverseOnlyLetters_917 {

	public String reverseOnlyLetters(String S) {
		char[] array = S.toCharArray();
		int start = 0;
		int end = S.length() - 1;
		
		while(start < end) {
			if(!Character.isLetter(array[start])) {
				start++;
				continue;
			}
			
			if(!Character.isLetter(array[end])) {
				end--;
				continue;
			}
			
			char c = array[start];
			array[start] = array[end];
			array[end] = c;
			start++;
			end--;
		}
        
		StringBuilder sb = new StringBuilder();
		sb.append(array);
		return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseOnlyLetters_917 s = new ReverseOnlyLetters_917();
		String S = "7_28]";
		String result = s.reverseOnlyLetters(S);
		System.out.println(result);
	}

}
