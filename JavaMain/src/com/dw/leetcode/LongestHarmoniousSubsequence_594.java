package com.dw.leetcode;

import java.util.*;

public class LongestHarmoniousSubsequence_594 {

    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<>();
        for(int i : nums) {
        	if(map.get(i) == null) {
        		map.put(i, 1);
        		list.add(i);
        	} else {
        		map.put(i, map.get(i) + 1);
        	}
        }
        
        Collections.sort(list);
        int start = list.get(0);
        int max = 0;
        for(int i=1;i<list.size();i++) {
        	int e = list.get(i);
        	if(e - start == 1) {
        		max = Math.max(max, map.get(e) + map.get(start));
        	}
        	
        	start = e;
        }
        
        return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestHarmoniousSubsequence_594 a = new LongestHarmoniousSubsequence_594();
		int[] nums = {1,1,1,1};
		int result = a.findLHS(nums);
		System.out.println(result);
	}

}
