package com.dw.leetcode;

import java.util.*;

//@example: Leetcode - 496. Next Greater Element I - https://leetcode.com/problems/next-greater-element-i/#/description
public class Next_Greater_Element_I_496 {
	
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        
        Map<Integer,Integer> position = new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++)
        {
        	position.put(nums[i], i);
        }
        
        for(int i=0;i<findNums.length;i++)
        {
        	int targetPosition = position.get(findNums[i]);
        	int tempResult = -1;
        	for(int k=targetPosition;k<nums.length;k++) {
        		if(nums[k]>findNums[i]) {
        			tempResult = nums[k];
        			break;
        		}
        	}
        	
        	result.add(tempResult);
        }
        
        int[] finalResult = new int[result.size()];
        
        for(int i=0;i<result.size();i++)
        	finalResult[i] = result.get(i);
        
        return finalResult;
    }

	public static void main(String[] args) {
		int[] num1 = {2,4};
		int[] num2 = {1,2,3,4};
		
		int[] result = nextGreaterElement(num1,num2);
		
		for(int i=0;i<result.length;i++)
			System.out.print(String.format("%d ", result[i]));
	}

}
