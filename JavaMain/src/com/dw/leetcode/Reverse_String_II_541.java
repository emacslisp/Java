package com.dw.leetcode;

//@example: Leetcode - 541. Reverse String II - https://leetcode.com/problems/reverse-string-ii/#/description
public class Reverse_String_II_541 {

	public String revert(String s) {

		char[] array = s.toCharArray();
		int length = s.length();
		for(int i=0;i <= length/2;i++) {
			char temp = array[length - 1 - i]; 
			array[length - 1 - i] = array[i];
			array[i] = temp;
		}
		
		return new String(array);
	}
	
    public String reverseStr(String s, int k) {
        if(k== 0|| k== 1) return s;
        
        
        return "";
    }
	
	public static void main(String[] args) {
		
	}

}
