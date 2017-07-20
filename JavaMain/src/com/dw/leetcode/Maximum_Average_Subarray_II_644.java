package com.dw.leetcode;

public class Maximum_Average_Subarray_II_644 {
    public static double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++) {
        	sum[i]=nums[i] + sum[i-1];
        	System.out.println(sum[i]);
        }
        
        double max = sum[k - 1]/(double)k;
        
        for(int i=k;i<nums.length;i++) {
        	double t = sum[i]/(double)(i+1);
        	if(t > max) {
        		max = t;
        	}
        }
        
        for(int i=0;i<nums.length - k;i++) {
        	for(int j=k;(i+j)<nums.length;j++) {
        		double t = (sum[i+j] - sum[i])/(double)j;
	        	if(t > max) {
	        		System.out.println(i);
	        		System.out.println(j);
	        		max = t;
	        	}
        	}
        }
        
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[8,9,3,1,8,3,0,6,9,2]
		//8
		int[] nums = {8,9,3,1,8,3,0,6,9,2};
		int k = 8;
		System.out.println(findMaxAverage(nums,k));
	}

}
