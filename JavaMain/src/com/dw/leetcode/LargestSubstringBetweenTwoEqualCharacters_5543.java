package com.dw.leetcode;
import java.util.*;

// https://leetcode.com/contest/weekly-contest-211/problems/largest-substring-between-two-equal-characters/
public class LargestSubstringBetweenTwoEqualCharacters_5543 {

	public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        
        for(int i=0;i<s.length();i++) {
        	char c = s.charAt(i);
        	
        	if(map.get(c) == null) {
        		map.put(c, new ArrayList<Integer>());
        	}
        	
        	List<Integer> li = map.get(c);
        	
        	li.add(i);
        }
        
        int max = -1;
        for(Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
        	
        	char c = entry.getKey();
        	List<Integer> li = entry.getValue();
        	
        	if(li.size() <= 1) {
        		continue;
        	}
        	
        	int interval = li.get(li.size() - 1) - li.get(0) - 1;
        	
        	if(max < interval)
        		max = interval;
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "cabbac";
		LargestSubstringBetweenTwoEqualCharacters_5543 s = new LargestSubstringBetweenTwoEqualCharacters_5543();
		int result = s.maxLengthBetweenEqualCharacters(input);
		System.out.println(result);
	}

}
