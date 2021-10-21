package com.dw.leetcode;

import java.util.HashMap;

public class MaximumNumberofWordsYouCanType1935 {

    public int canBeTypedWords(String text, String brokenLetters) {
    	HashMap<Character, Integer> map = new HashMap<>();
    	
    	for(char c : brokenLetters.toCharArray()) {
    		map.put(c, 1);
    	}
    	
    	String[] word = text.split(" ");
    	int counter = 0;
    	for(String w: word) {
    		boolean canBeTyped = true;
    		for(char c : w.toCharArray()) {
    			if(map.get(c) != null) {
    				canBeTyped = false;
    			}
    		}
    		
    		if(canBeTyped) counter++;
    	}
    	return counter;
    }
    
	public static void main(String[] args) {
		
	}
}
