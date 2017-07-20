package com.dw.leetcode;

public class Maximum_Average_Subarray_I_643 {
	
	public static double findMaxAverage(int[] nums, int k) {       
        int[] sum = new int[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++) {
        	sum[i]=nums[i] + sum[i-1];
        	//System.out.println(sum[i]);
        }
        
        double max = -Double.MAX_VALUE;
        
        for(int i=-1;i<nums.length - k;i++) {
        	
        	if(i==-1) {
        		if(max < sum[i+k])
        			max = sum[i+k];
        	}
        	else if(max < (sum[i+k] - sum[i])) {
        		max = sum[i+k] - sum[i];
        	}
        }
        
        return max/(double)k;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1};
		int k = 1;
		System.out.println(findMaxAverage(nums,k));
	}

}
