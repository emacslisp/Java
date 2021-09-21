package com.dw.leetcode;

public class MaxConsecutiveOnes {
	
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0;
        int max = 0;
        for(int num : nums) {
        	if (num == 1) counter++;
        	if (num == 0) {
        		if(max < counter) max = counter;
        		counter = 0;
        	}
        }
        return Math.max(max, counter);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,0,1,1,0,1};
		
		MaxConsecutiveOnes s = new MaxConsecutiveOnes();
		
		int result = s.findMaxConsecutiveOnes(nums);
		System.out.println(result);
	}

}
