package com.dw.leetcode;

// https://leetcode.com/contest/weekly-contest-196/problems/last-moment-before-all-ants-fall-out-of-a-plank/
public class LastMomentBeforeAllAntsFallOut_5453 {

	public int getLastMoment(int n, int[] left, int[] right) {

        
        int maxLeft = 0;
        for(int i=0;i<left.length;i++) {
        	if(left[i] > maxLeft) {
        		maxLeft = left[i];
        	}
        }
        
        int maxRight = 0;
        
        for(int i=0;i<right.length;i++) {
        	if( (n - right[i]) > maxRight) {
        		maxRight = n - right[i];
        	}
        }

        return maxLeft> maxRight? maxLeft: maxRight;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LastMomentBeforeAllAntsFallOut_5453 s= new LastMomentBeforeAllAntsFallOut_5453();
		int n= 4;
		int[] left = {4, 3};
		int[] right = {0, 1};
		System.out.println(s.getLastMoment(n, left, right));
	}

}
