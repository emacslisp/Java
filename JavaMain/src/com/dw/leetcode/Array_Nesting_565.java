package com.dw.leetcode;

import java.util.HashMap;

//@example: Leetcode - 565. Array Nesting - https://leetcode.com/problems/array-nesting/#/description
public class Array_Nesting_565 {
	
	HashMap<Integer, Integer> finalResult = new HashMap<Integer, Integer>();
	
	public int maxNest(int[] nums,int index) {
		int result = 0;
		int i = index;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		while(map.get(i) == null) {
			
			if(finalResult.get(i) != null)
			{
				return result += finalResult.get(i);
			}
			
			map.put(i,result);
			i = nums[i];
			result++;
		}
		
		for(int k : map.keySet()) {
			finalResult.put(k, result - map.get(k));
		}
		
		return result;
	}
	
	public int arrayNesting(int[] nums) {
        int result = 0;
        
        for(int i=0;i<nums.length;i++) {
        	int temp = maxNest(nums,i);
        	if(result < temp) {
        		result = temp;
        	}
        }
        
        return result;
    }

	public static void main(String[] args)
	{
		Array_Nesting_565 x = new Array_Nesting_565();
		// TODO Auto-generated method stub
		int A[] = {0,2,1};
		System.out.println(x.arrayNesting(A));
	}

}
