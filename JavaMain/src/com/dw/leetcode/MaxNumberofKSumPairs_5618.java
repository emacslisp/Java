package com.dw.leetcode;

import java.util.HashMap;

public class MaxNumberofKSumPairs_5618 {

	public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i=0;i<nums.length;i++) {
    		if(map.get(nums[i]) == null) {
    			map.put(nums[i], 1);
    		}
    		else {
	    		int counter = map.get(nums[i]);
	    		map.put(nums[i], ++counter);
    		}
        }
        
        int pair = 0;
        
        for(int i=0;i<nums.length;i++) {
        	int counter = map.get(nums[i]);
        	
        	int target = k - nums[i];
        	
        	if(map.get(target) == null) continue;
        	
        	int counter2 = map.get(target);
        	
        	if(nums[i] == target) {
        		counter -= 2;
        		if(counter >= 0) {
        			pair++;
        			map.put(nums[i], counter);
        		}
        	} else {
        		if(counter > 0 && counter2 > 0) {
        			pair++;
        			counter -=1;
        			counter2 -= 1;
        			map.put(nums[i], counter);
        			map.put(target, counter2);
        		}
        	}
        }
        
        return pair;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
		int k=2;
		MaxNumberofKSumPairs_5618 s= new MaxNumberofKSumPairs_5618();
		int result = s.maxOperations(nums, k);
		System.out.println(result);
	}

}
