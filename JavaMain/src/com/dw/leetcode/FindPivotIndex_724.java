package com.dw.leetcode;

public class FindPivotIndex_724 {
	public static int pivotIndex(int[] nums) {
		if(nums == null || nums.length == 0) return -1; 
		if(nums.length == 1) return 0;
		if(nums.length==2) return -1;
		
        int result = -1;
        
        int[] array = new int[nums.length];
        
        array[0]=nums[0];
        for(int i=1;i<nums.length;i++) {
        	array[i] = array[i-1] + nums[i];
        }
        
        long total = array[array.length-1];
        
        // i=0 case
        if(total - array[0]==0) {
        	return 0;
        }
        
        for(int i=1;i<nums.length;i++) {
        	if(total - array[i] == array[i-1] ){
        		result = i;
        		break;
        	}
        }
        
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int array[]={1, 7, 3, 6, 5, 6};
		int array[]={1, 2, 3};
		System.out.println(pivotIndex(array));
	}

}
