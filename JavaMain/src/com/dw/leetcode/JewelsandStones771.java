package com.dw.leetcode;

import java.util.*;

public class JewelsandStones771 {
	
    public int numJewelsInStones(String jewels, String stones) {
     
    	HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
    	
    	for(char c : jewels.toCharArray()) {
    		hashMap.put(c, 1);
    	}
    	
    	int counter = 0;
    	for(char c: stones.toCharArray()) {
    		Integer t = hashMap.get(c);
    		
    		if(t != null) counter++;
    	}
    	
    	return counter;
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JewelsandStones771 s= new JewelsandStones771();
		String a = "aA";
		String b = "aAAbbbb";
		int result = s.numJewelsInStones(a, b);
		System.out.println(result);
	}

}
