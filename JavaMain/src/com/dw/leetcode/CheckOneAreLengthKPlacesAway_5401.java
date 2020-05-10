package com.dw.leetcode;

public class CheckOneAreLengthKPlacesAway_5401 {
	// https://leetcode.com/contest/weekly-contest-187/problems/check-if-all-1s-are-at-least-length-k-places-away/
	
    public boolean kLengthApart(int[] nums, int k) {
        int p = 0;
        for(int i=0;i<nums.length;i++) {
        	if(nums[i] == 1) {
        		p = i;
        		break;
        	}
        }
        
    	for(int i=p+1;i<nums.length;i++) {
    		if(nums[i] == 1) {
    			
    			if (k > (i - p - 1)) {
    				return false;
    			}
    			
    			p = i;
    		}
    	}
    	
    	return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,0,0,1,0,1};
		int k = 2;
		
		CheckOneAreLengthKPlacesAway_5401 s= new CheckOneAreLengthKPlacesAway_5401();
		
		System.out.println(s.kLengthApart(nums, k));
	}

}
