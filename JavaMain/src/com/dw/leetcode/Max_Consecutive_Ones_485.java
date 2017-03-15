package com.dw.leetcode;

//@example: Leetcode - 485. Max Consecutive Ones - https://leetcode.com/problems/max-consecutive-ones/#/description
public class Max_Consecutive_Ones_485 {

	public static int findMaxConsecutiveOnes(int[] nums) {
        
		int result = 0;
		int counter = 0;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i] == 0)
			{
				if(counter > result)
					result = counter;
				
				counter = 0;
				
				continue;
			}
			else
			{
				counter++;
			}
		}
		
		if(counter > result)
			return counter;
		
		return result;
    }
	
	public static void main(String[] args) {

		int array[]={1,1,0,1,1,1};
		
		System.out.println(findMaxConsecutiveOnes(array));
		
	}
}
