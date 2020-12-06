package com.dw.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumIncompatibility_5619 {

	public int minimumIncompatibility(int[] nums, int k) {
		
		Arrays.sort(nums);
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i=0;i<nums.length;i++) {
    		map.put(i, map.getOrDefault(i, 0) + 1);
        }
		
		int counter = nums.length/k;
		

        for(int i : nums) {
        	if(map.get(i) == 0) continue;
        	for(int j=i;j<i+counter;j++) {
        		
        	}
        }

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
