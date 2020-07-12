package com.dw.leetcode;

import java.util.*;
// https://leetcode.com/problems/number-of-good-pairs/
public class NumberofGoodPairs_1512 {
	public int numIdenticalPairs(int[] nums) {
		HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int i =0; i<nums.length;i++) {
			if(hashMap.get(nums[i]) == null) {
				hashMap.put(nums[i], new ArrayList<Integer>());
			}
			
			ArrayList<Integer> list = hashMap.get(nums[i]);
			list.add(i);
		}
		
		int result = 0;
		for(int key: hashMap.keySet()) {
			ArrayList<Integer> list = hashMap.get(key);
			
			int n = list.size();
			
			result += n*(n-1)/2;
		}
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 1, 1, 1};
		NumberofGoodPairs_1512 s= new NumberofGoodPairs_1512();
		System.out.println(s.numIdenticalPairs(nums));
	}

}
