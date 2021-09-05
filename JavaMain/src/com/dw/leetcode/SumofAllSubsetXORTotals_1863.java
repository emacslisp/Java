package com.dw.leetcode;

public class SumofAllSubsetXORTotals_1863 {

    public int subsetXORSum(int[] nums) {
    	int result = 0;
    	int x = (int)Math.pow(2, nums.length) - 1;
        for(int i=1;i<=x;i++) {
        	int p = i;
        	int r = 0;
        	for(int j=0;j<nums.length;j++) {
        		int t = p & 1;
        		p >>= 1;
        	
        		if (t == 1) {
    				r ^= nums[j];
        		}
        	}
        	
        	result += r;
        }
        
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumofAllSubsetXORTotals_1863 a = new SumofAllSubsetXORTotals_1863();
		int[] nums = {1, 3};
		int result = a.subsetXORSum(nums);
		System.out.println(result);
	}
	
}
