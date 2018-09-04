package com.dw.leetcode;

public class SortColors_75 {
	
	private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
	
	public void sortColors(int[] nums) {
		if(nums==null || nums.length==0)
            return ;
		int start = 0;
		int i = 0;
		int end = nums.length - 1;
		
		while(i<=end) {
			if (nums[i] == 0) {
				swap(nums,start, i);
				start++;
				i++;
			}
			else if (nums[i] == 2) {
				swap(nums,i,end);
				end--;
			}
			else
				i++;
		}
    }
	
	public static void main(String[] args) {
		int[] nums = {2,0,1};
		SortColors_75 s= new SortColors_75();
		s.sortColors(nums);
		for(int i=0;i<nums.length;i++) {
		System.out.println(nums[i]);
		}
		
	}
}
