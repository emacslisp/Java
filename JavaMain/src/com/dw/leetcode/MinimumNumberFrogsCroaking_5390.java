package com.dw.leetcode;

import java.util.HashMap;

public class MinimumNumberFrogsCroaking_5390 {
	
	public int minNumberOfFrogs(String croakOfFrogs) {
		int[] counter = new int[5];
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String temp = "croak";
		for(int i=0;i<temp.length();i++) {
			map.put(temp.charAt(i),i);
		}
		
		int max = 0;
		int result = 0;
		
		for(int i=0;i<croakOfFrogs.length();i++) {
			char c = croakOfFrogs.charAt(i);
			
			counter[map.get(c)] ++;
			
			max = counter[0] - counter[counter.length-1];
			
			if(counter[map.get(c)] > counter[0]) {
				return -1;
			}
			
			if(max > 0 && result<max) {
				result = max;
			}
		}
		
		for(int i=0;i<counter.length;i++) {
			if(counter[i] != counter[0]) {
				return -1;
			}
		}
		
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String croakOfFrogs = "aoocrrackk";
		MinimumNumberFrogsCroaking_5390 s = new MinimumNumberFrogsCroaking_5390();
		System.out.println(s.minNumberOfFrogs(croakOfFrogs));
	}

}
