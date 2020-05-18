package com.dw.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// https://leetcode.com/contest/weekly-contest-189/problems/rearrange-words-in-a-sentence/
public class RearrangeWords_5413 {

	public String arrangeWords(String text) {
        String result = "";
        
        String[] input = text.split(" ");
        
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        
        for(String s: input) {
        	int l = s.length();
        	
        	if(map.get(l) == null) {
        		map.put(l, new ArrayList<String>());
        	}
        	
        	ArrayList<String> a = map.get(l);
        	
        	a.add(s.toLowerCase());
        }
        
        ArrayList<Integer> sortedKeys=new ArrayList<Integer>(map.keySet());
        
        Collections.sort(sortedKeys);
        
        for(Integer x : sortedKeys) {
        	ArrayList<String> a  = map.get(x);
        	
        	for(String s : a) {
        		result += s;
        		result += " ";
        	}
        }
        
        result = Character.toUpperCase(result.charAt(0)) + result.substring(1, result.length() - 1);
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RearrangeWords_5413 s = new RearrangeWords_5413();
		String text = "To be or not to be";
		
		System.out.println(s.arrangeWords(text));
	}

}
