package com.dw.leetcode;

// https://leetcode.com/contest/weekly-contest-220/problems/jump-game-vi/
public class JumpGameVI_5631 {
	/*public int foo(int[] nums, int index, int k) {
		if(index >= nums.length) {
			return 0;
		}
		
		int total = Integer.MIN_VALUE;
		for (int i=1;i<=k;i++) {
			int t =  nums[index] + foo(nums, index + i, k);
			if(total < t) {
				total = t;
			}
		}
		return total;
	}*/
	public int maxResult(int[] nums, int k) {
        int result = 0;
        int[] dp = new int[nums.length];
        
        for(int i=0;i<dp.length;i++) {
			dp[i] = Integer.MIN_VALUE;
		}
        
        dp[0] = nums[0];
        
        for(int i=1;i<nums.length;i++) {
        	for(int j=1;j<=k;j++) {
        		if(i-j >=0 && i-j <= nums.length) {
        			dp[i] = Math.max(dp[i], dp[i-j] + nums[i]);
        		}
        	}
        }
        return dp[dp.length - 1];
    }

	public static void main(String[] args) {
		int[] nums = {10,-5,-2,4,0,3};
		int k = 3;
		JumpGameVI_5631 s= new JumpGameVI_5631();
		int result = s.maxResult(nums, k);
		System.out.println(result);
	}
}
