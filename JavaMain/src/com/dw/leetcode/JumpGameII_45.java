package com.dw.leetcode;

public class JumpGameII_45 {

	public int jump(int[] nums) {
		if(nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        
        for(int i=0;i<dp.length;i++) {
        	dp[i] = Integer.MAX_VALUE;
        }
        
        dp[0] = 0;

        for(int i=0;i<nums.length;i++) {
        	for(int j=1;j<=nums[i];j++) {
        		if(i+j < nums.length)
        			dp[i+j] = Math.min(dp[i+j], dp[i] + 1);
        	}
        }
        
        return dp[dp.length - 1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGameII_45 s= new JumpGameII_45();
		int[] nums = {2,3,1,1,4};
		int result = s.jump(nums);
		System.out.println(result);
	}

}
