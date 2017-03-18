package com.dw.leetcode;

import java.util.*;

//@example: Leetcode - 387. First Unique Character in a String - https://leetcode.com/problems/first-unique-character-in-a-string/#/description
public class First_Unique_Character_in_a_String_387 {
	public static int firstUniqChar(String s) {
		int result = 0;
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		for(int i=0;i<s.length();i++)
		{
			map.put(s.charAt(i), i);
		}
		
		for(int i=0;i<s.length();i++) {
			int position = map.put(s.charAt(i), i);
			
			if(position ==i)
				return i;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "loveleetcode";
		System.out.println(firstUniqChar(s));
	}

}
