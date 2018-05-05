package com.dw.leetcode;

public class SearchInsertPosition_35 {
	
    public int searchInsert(int[] nums, int target) {
        int result = 0;
        
        int start = 0;
        int end = nums.length-1;
        
        if(target <= nums[start]) return 0;
        if(target == nums[end]) return nums.length - 1;
        if(target > nums[end]) return nums.length;
        
        int middle = (start+end)/2;
        while(start < (end-1)) {
        	if(target == nums[middle]) {
        		return middle;
        	}
        	else if(target < nums[middle]) {
        		end = middle;
        	}
        	else if(target > nums[middle]) {
        		start = middle;
        	}
        	
        	middle = (start + end)/2;
        }
        
        return start+1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsertPosition_35 a = new SearchInsertPosition_35();
		int[] nums = {1,3,5,6};
		System.out.println(a.searchInsert(nums, 4));
	}

}
