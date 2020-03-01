package com.dw.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class How_Many_Numbers_5344 {

	public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] copyNums = new int[nums.length];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i=0;i<nums.length;i++) {
        	copyNums[i] = nums[i];
        }
        Arrays.sort(copyNums);
        int counter = 0;
        map.put(copyNums[0], counter);
        
        for(int i=1;i<copyNums.length;i++) {
        	if(copyNums[i] == copyNums[i-1]) {
        		++counter;
        	}
        	else {
        		map.put(copyNums[i], ++counter);
        	}
        }
        
        int[] result = new int[nums.length];
        
        for (int i=0;i<nums.length;i++) {
        	result[i] = map.get(nums[i]);
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {7,7,7,7};
		How_Many_Numbers_5344 s = new How_Many_Numbers_5344();
		
		int[] result = s.smallerNumbersThanCurrent(input);
		
		for (int i=0;i<result.length;i++) {
        	System.out.print(result[i] + "\t");
        }
		System.out.println();
		
	}

}
