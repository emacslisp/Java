package com.dw.leetcode;

import java.util.ArrayList;
import java.util.List;

public class StringMatchingArray_5380 {
	public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<String>();
        
        for(String w: words) {
        	for(String s: words) {
        		if(!s.equals(w) && s.contains(w)) {
        			result.add(w);
        			break;
        		}
        	}
        }
        
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"mass","as","hero","superhero"};
		StringMatchingArray_5380 s = new StringMatchingArray_5380();
		List<String> result = s.stringMatching(words);
		
		for(String w: result) {
			System.out.println(w);
		}
	}

}
