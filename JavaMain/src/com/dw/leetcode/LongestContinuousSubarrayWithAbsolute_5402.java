package com.dw.leetcode;

//https://leetcode.com/contest/weekly-contest-187/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
public class LongestContinuousSubarrayWithAbsolute_5402 {
	
    class  SegmentTree {
	    SegmentTree left;
        SegmentTree right;
        int start;
        int end;
        int max;
        int min;
        SegmentTree(int start, int end, int max, int min){
            this.start = start;
            this.end = end;
            this.max = max;
            this.min = min;
        }

    }

    public int longestSubarray(int[] nums, int limit) {
    	int maxLength = 0;
        for(int i=0;i<nums.length;i++) {
        	int max = nums[i];
        	int min = nums[i];
        	for(int j=i;j<nums.length;j++) {
        		if(nums[j] > max) {
        			max = nums[j];
        		}
        		
        		if(nums[j] < min) {
        			min = nums[j];
        		}
        		
        		if(limit >= max - min) {
        			if(maxLength < j - i + 1) {
        				maxLength = j - i + 1;
        			}
        		}
        	}
        }
        
        return maxLength;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestContinuousSubarrayWithAbsolute_5402 s = new LongestContinuousSubarrayWithAbsolute_5402();
		
		int[] nums = {10,1,2,4,7,2};
		int limit = 5;
		
		//int[] nums = {8,2,4,7};
		//int limit = 4;
		
		//int[] nums = {4,2,2,2,4,4,2,2};
		//int limit = 0;
		
		System.out.println(s.longestSubarray(nums, limit));
	}

}
