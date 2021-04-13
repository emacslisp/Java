package com.dw.leetcode;

public class SignoftheProductofanArray_1822 {
	public int arraySign(int[] nums) {
		int counter = 0;
		boolean isZero = false;
		for(int x: nums) {
			if(x < 0) {
				counter++;
			} else if(x == 0) {
				isZero = true;
			}
		}
		
		if(isZero) return 0;
		
		if(counter%2 == 0) return 1;
		
		return -1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,1,-1,1,-1};
		SignoftheProductofanArray_1822 s = new SignoftheProductofanArray_1822();
		int result = s.arraySign(nums);
		System.out.println(result);
	}

}
