package com.dw.leetcode;

import java.util.HashMap;

public class MaximumErasureValue_5630 {

	public int maximumUniqueSubarray(int[] nums) {
    	int result = 0;
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int index = 0;
    	int total = 0;
    	for (int i=0;i<nums.length;i++) {
    		if (map.get(nums[i]) == null) {
    			map.put(nums[i], i);
    			total += nums[i];
    		}
    		else {
    			if(result < total) {
    				result = total;
    			}
    			
    			int t = map.get(nums[i]);
    			for(int j=index;j<=t;j++) {
    				map.remove(nums[j]);
    				total -= nums[j];
    			}
    			
    			map.put(nums[i], i);
    			total += nums[i];
    			index = t+1;
    		}
    	}
    	
    	if(result < total) {
    		result = total;
    	}
    	
    	return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5,2,1,2,5,2,1,2,5};
		MaximumErasureValue_5630 s = new MaximumErasureValue_5630();
		int result = s.maximumUniqueSubarray(array);
		System.out.println(result);
	}

}
