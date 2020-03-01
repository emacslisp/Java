package com.dw.leetcode;

public class FindNumbers_1295 {
	public int numberDigit(int num) {
		int n = num;
		int counter = 0;
		while(n>0) {
			n = n/10;
			counter++;
		}
		return counter;
	}
	public int findNumbers(int[] nums) {
		int counter=0;
        for(int i=0;i<nums.length;i++) {
        	if(numberDigit(nums[i]) %2 == 0)
        		counter++;
        }
        return counter;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {555,901,482,1771};
		
		FindNumbers_1295 s = new FindNumbers_1295();
		System.out.println(s.findNumbers(nums));
	}

}
