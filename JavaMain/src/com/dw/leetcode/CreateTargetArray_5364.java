package com.dw.leetcode;

public class CreateTargetArray_5364 {
    public int[] createTargetArray(int[] nums, int[] index) {
    
    	int[] result = new int[nums.length];
    	
    	for(int i=0;i<nums.length;i++) {
    		//move all elements
    		for(int j=i;j>index[i];j--) {
    			result[j] = result[j-1];
    		}
    		result[index[i]] = nums[i]; 
    	}
    	
    	return result;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,0};
		int[] index = {0,1,2,3,0};
		
		CreateTargetArray_5364 s = new CreateTargetArray_5364();
		
		int[] result = s.createTargetArray(nums, index);
		
		for(int i = 0;i<result.length;i++) {
			System.out.print(result[i] + "\t");
		}
	}

}
