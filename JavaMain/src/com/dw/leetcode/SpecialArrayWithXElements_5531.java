package com.dw.leetcode;

import java.util.Arrays;

public class SpecialArrayWithXElements_5531 {
	public int specialArray(int[] nums) {
        Arrays.sort(nums);
        
        for(int i=0;i<=1000;i++) {
        	int j;
        	for(j=0;j<nums.length;j++) {
        		if(nums[j] >= i) {
        			break;
        		}
        	}
        	
        	if(nums.length - j == i) {
        		return i;
        	}
        }
        
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpecialArrayWithXElements_5531 s= new SpecialArrayWithXElements_5531();
		int[] nums = {0,4,3,0,4};
		int result = s.specialArray(nums);
		System.out.println(result);
	}

}
