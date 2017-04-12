package com.dw.leetcode;

public class Reverse_Words_in_String_III {
	public static String reverse(String s) {
		char[] array = s.toCharArray();
		
		for(int i=0;i<array.length/2;i++){
			char temp = array[i];
			array[i]=array[array.length - i -1];
			array[array.length - i -1] = temp;
		}
		
		return new String(array);
		
	}

	public static String reverseWords(String s) {
		String[] temp = s.split(" ");
		StringBuilder builder = new StringBuilder();
		for(String x : temp) {
			builder.append(reverse(x));
			builder.append(" ");
		}
		
		return builder.toString().substring(0, builder.toString().length() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("Let's   take LeetCode contest"));
	}

}
;