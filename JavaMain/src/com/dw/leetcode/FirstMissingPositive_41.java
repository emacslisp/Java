package com.dw.leetcode;
import java.util.*;

public class FirstMissingPositive_41 {

    public int firstMissingPositive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++) {
        	map.put(nums[i], i);
        }
        
        for(int i=1;;i++) {
        	if(map.get(i) == null)
        		return i;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstMissingPositive_41 f = new FirstMissingPositive_41();
		int[] nums = {1};
		int result = f.firstMissingPositive(nums);
		System.out.println(result);
	}

}
