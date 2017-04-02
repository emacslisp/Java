package com.dw.leetcode;

//@example: Leetcode - 541. Reverse String II - https://leetcode.com/problems/reverse-string-ii/#/description
public class Reverse_String_II_541 {
	public static char[] array;
	public static void revert(int start, int end) {

		
		for(int i=start;i <= (start+end)/2;i++) {
			char temp = array[i];
			array[i] = array[start+end - i];
			array[start+end - i] = temp;
		}
	}
	
    public static String reverseStr(String s, int k) {
        if(k== 0|| k== 1) return s;
        
        array = s.toCharArray();
        int length = s.length();

        int time = length/(2*k);
        int rest = length%(2*k);
        int index = 0;
        while(index < length && time > 0) {
            revert(index,index+k-1);
            time--;
            index += 2*k;
        }
        
        time = length/(2*k);
        
        if(rest >= k)
        {
        	revert(2*k*time,2*k*time+k-1);
        }
        
        if(rest < k)
        {
        	revert(2*k*time,2*k*time+rest-1);
        }
        
        return new String(array);
    }
	
	public static void main(String[] args) {
		System.out.println(reverseStr("abc",4));
	}

}
