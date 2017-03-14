package com.dw.leetcode;

import java.util.Arrays;

//@example: Leetcode - 414. Third Maximum Number - https://leetcode.com/problems/third-maximum-number/#/description
public class Third_Maximum_Number_414 {
	
	public static int thirdMax(int[] nums) {
		
        if(nums.length<3) return nums[nums.length - 1];
        
        Arrays.sort(nums);
        
        int[] resultArray = new int[3];
        
        for(int i=0;i<resultArray.length;i++)
        	resultArray[i] = 0;
        
        int index = 0;
        resultArray[index] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--)
        {
        	if(index == 2) break;
        	
        	if(resultArray[index]!=nums[i])
        	{
        		index++;
        		resultArray[index] = nums[i];
        	}
        }
        
        if(index < 2) return resultArray[0];
        
        return resultArray[2];
    }
	
    public static void main(String[] args) {
    	int[] testArray = {1,1,2};
    	
    	System.out.println(thirdMax(testArray));
    }
	
}
