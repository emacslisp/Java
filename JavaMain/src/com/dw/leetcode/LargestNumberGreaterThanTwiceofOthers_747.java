package com.dw.leetcode;

public class LargestNumberGreaterThanTwiceofOthers_747 {
	
	public int dominantIndex(int[] nums) {
        int result = -1;
        
        int max = Integer.MIN_VALUE;
        int index = -1;
        
        for(int i=0;i<nums.length;i++) {
        	if(max <nums[i]) {
        		max = nums[i];
        		index = i;
        	}
        }
        
        
        boolean flag = true;
        for(int i=0;i<nums.length;i++) {
        	if(max > nums[i] && max >= (2*nums[i])) {
        		continue;
        	}
        	else if(max == nums[i]) continue;
        	
        	else {
        		flag = false;
        		break;
        	}
        }
        
        if(flag) {
        	result = index;
        }
        
        return result;
    }
	
    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};
        LargestNumberGreaterThanTwiceofOthers_747 s = new LargestNumberGreaterThanTwiceofOthers_747();
        System.out.println(s.dominantIndex(nums));
    }

}
