package com.dw.leetcode;

import java.util.*;

public class MostCommonWord_819 {

    public String mostCommonWord(String paragraph, String[] banned) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<paragraph.length(); i++){
            char ch = paragraph.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                sb.append(ch);
            }else if(ch >= 'A' && ch <= 'Z'){
                char c = (char)(ch - 'A' + 'a');
                sb.append(c);
            }else{
                String word = String.valueOf(sb);
                if(sb.length() > 0 && !set.contains(word)){
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
                sb = new StringBuilder();
            }
        }
        
        if(sb.length() > 0) map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        
        for(String s: banned) {
        	String t = s.toLowerCase();
        	if(m.containsKey(t)) {
        		m.put(t, m.get(t) + 1);
        	} else {
        		m.put(t, 1);
        	}
        }
        
        String result="";
        int max = 0;
        
        for(String s: map.keySet()) {
        	if(m.containsKey(s)) continue;
        	
        	int counter = map.get(s);
        	if(counter > max) {
        		result = s;
        		max = counter;
        	}
        }
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MostCommonWord_819 s = new MostCommonWord_819();
		
		String paragraph = "Bob";
		String[] banned = {};
		
		String result = s.mostCommonWord(paragraph, banned);
		System.out.println(result);
	}

}
