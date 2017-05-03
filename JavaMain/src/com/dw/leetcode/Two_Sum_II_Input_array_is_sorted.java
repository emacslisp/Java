package com.dw.leetcode;

public class Two_Sum_II_Input_array_is_sorted {
	
	public int[] twoSum(int[] numbers, int target) {
       
		int start = 0, end = numbers.length - 1;
		
		while((numbers[start] + numbers[end]) != target) {
			if(numbers[start] + numbers[end] < target) start ++;
			if(numbers[start] + numbers[end] > target) end--;
		}
		
		return new int[] {start +1,end+1};
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{2, 7, 11, 15};
		Two_Sum_II_Input_array_is_sorted s = new Two_Sum_II_Input_array_is_sorted();
		int[] result = s.twoSum(array,13);
		
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

}
