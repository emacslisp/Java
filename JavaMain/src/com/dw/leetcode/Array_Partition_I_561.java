package com.dw.leetcode;

import java.util.Arrays;

//@example: leetcode - 561. Array Partition I - https://leetcode.com/problems/array-partition-i/#/description
public class Array_Partition_I_561 {

	public int arrayPairSum(int[] nums) {
        int result = 0;
		Arrays.sort(nums);
		
		for(int i=0;i<nums.length;i+=2){
			result += nums[i];
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array_Partition_I_561 a = new Array_Partition_I_561();
		System.out.println(a.arrayPairSum(new int[] {1,2,3,4}));
	}

}
