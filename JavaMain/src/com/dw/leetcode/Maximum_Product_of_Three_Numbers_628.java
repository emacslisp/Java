package com.dw.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Maximum_Product_of_Three_Numbers_628 {
	
	public static int maximumProduct(int[] nums) {
        
        
		if(nums.length==3) {
			int i = nums.length -1;
			return nums[i]*nums[i-1]*nums[i-2];
		}
		
		int[] op = new int[nums.length];
		
		int counter = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]<0) {
				counter++;
				op[i] = -nums[i];
				nums[i] = 0;
			}
			else
				op[i]=0;
		}
		
		Arrays.sort(nums);
		Arrays.sort(op);
		
		if(nums.length == counter) {
			return op[0]*op[1]*op[2]*-1;
		}
		
		int i = nums.length -1;
		
		if((nums.length - counter)< 3) return nums[i]*op[i]*op[i-1];
		
		
		return Math.max(nums[i]*op[i]*op[i-1],nums[i]*nums[i-1]*nums[i-2]);
    }

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		int[] array = new int[] {-4,-3,-2,-1,60};
		System.out.println(maximumProduct(array));
	}

}
