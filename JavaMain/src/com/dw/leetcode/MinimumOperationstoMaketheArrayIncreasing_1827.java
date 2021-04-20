package com.dw.leetcode;

public class MinimumOperationstoMaketheArrayIncreasing_1827 {

	public int minOperations(int[] nums) {
		if(nums.length <= 1) return 0;
		int result = 0;
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i+1] <= nums[i]) {
				int t = nums[i+1];
				nums[i+1] = nums[i]+1;
				
				result += (nums[i+1] - t);
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumOperationstoMaketheArrayIncreasing_1827 s = new MinimumOperationstoMaketheArrayIncreasing_1827();
		int[] nums = {1,5,2,4,1};
		int result = s.minOperations(nums);
		System.out.println(result);
	}

}
