package com.dw.leetcode;

import java.util.Arrays;

public class MinimizeMaximumPairSuminArray1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int max = 0;
        for(int i=0;i<nums.length/2;i++) { 
        	int sum = nums[i] + nums[nums.length - i - 1];
        	if(max < sum) max = sum;
        }
        
        return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimizeMaximumPairSuminArray1877 s = new MinimizeMaximumPairSuminArray1877();
		int[] nums = {3,5,4,2,4,6};
		int result = s.minPairSum(nums);
		System.out.println(result);
	}

}
