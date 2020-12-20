package com.dw.leetcode;

public class JumpGame_55 {
	
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int[] dp = new int[nums.length];
        
        for(int i=0;i<dp.length;i++) {
        	dp[i] = Integer.MIN_VALUE;
        }
        
        dp[0] = nums[0];
        
        for(int i=0;i<nums.length;i++) {
        	for(int j=1;j<=nums[i];j++) {
        		if(i+j < nums.length)
        			dp[i+j] = Math.max(dp[i+j], dp[i] + j);
        	}
        }
        
        return dp[dp.length - 1] > 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGame_55 s= new JumpGame_55();
		int[] nums = {0,2,3};
		boolean result = s.canJump(nums);
		System.out.println(result);
	}

}
