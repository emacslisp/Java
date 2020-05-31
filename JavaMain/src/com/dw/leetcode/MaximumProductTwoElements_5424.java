package com.dw.leetcode;

import java.util.Arrays;

public class MaximumProductTwoElements_5424 {
	public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumProductTwoElements_5424 s = new MaximumProductTwoElements_5424();
		
		int[] nums = {1,5,4,5};
		
		System.out.println(s.maxProduct(nums));
	}

}
