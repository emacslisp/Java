package com.dw.leetcode;

public class ThreeConsecutiveOdds_5185 {
	public boolean threeConsecutiveOdds(int[] arr) {
        for(int i=0; i <= arr.length - 3;i++) {
        	if(arr[i]%2 == 1 && arr[i+1]%2 == 1 && arr[i+2]%2 == 1) {
        		return true;
        	}
        }
        
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeConsecutiveOdds_5185 s= new ThreeConsecutiveOdds_5185();
		int[] arr = {1,1,1};
		boolean result = s.threeConsecutiveOdds(arr);
		System.out.println(result);
	}

}
