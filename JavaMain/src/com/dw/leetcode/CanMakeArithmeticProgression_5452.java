package com.dw.leetcode;

import java.util.Arrays;

//https://leetcode.com/contest/weekly-contest-196/problems/can-make-arithmetic-progression-from-sequence/


public class CanMakeArithmeticProgression_5452 {
	public boolean canMakeArithmeticProgression(int[] arr) {

		if(arr.length == 2) return true;
		
		Arrays.sort(arr);
		int inteval = arr[1] - arr[0];
		for(int i=1;i<arr.length-1;i++) {
			if(arr[i+1] - arr[i] != inteval) {
				return false;
			}
		}
		
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
