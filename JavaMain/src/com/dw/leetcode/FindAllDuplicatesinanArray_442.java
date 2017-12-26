package com.dw.leetcode;

import java.util.*;
/*
 * 
 * 
 * 
 * */
public class FindAllDuplicatesinanArray_442 {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		
		if(nums == null) return null;
		if(nums.length ==0) return result;
		
		for(int i=0;i<nums.length;i++) {
			int index = Math.abs(nums[i])-1;
			if(nums[index]<0) {
				result.add(index+1);
			}
			else {
				nums[index] = -nums[index];
			}
		}
		
		return result;
    }

    public static void main(String[] args) {
        int[] nums ={4,3,2,7,8,2,3,8};
        
        FindAllDuplicatesinanArray_442 s = new FindAllDuplicatesinanArray_442();
        List<Integer> result = s.findDuplicates(nums);
        for(int i : result) {
        	System.out.println(i);
        }
    }
}
