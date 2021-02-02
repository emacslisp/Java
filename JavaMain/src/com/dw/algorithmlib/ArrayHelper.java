package com.dw.algorithmlib;

import java.util.Arrays;

public class ArrayHelper {
	
	/**
	 * Revert Array
	 * @param inputArray
	 * @return
	 */
	public static <E> E[] revertArray(E[] inputArray) {
		
		int i = 0;
		
		while(i<inputArray.length) {
			int end = inputArray.length - i - 1;
			if(end<i) {
				break;
			}
			
			E temp = inputArray[i];
			inputArray[i]=inputArray[end];
			inputArray[end] = temp;
			
			i++;
		}
		
		return inputArray;
	}
	
	/**
	 * 
	 * @param inputArray
	 * @param isRevert
	 * @return
	 */
	public static <T extends Comparable<T>> T[] sortArray(T[] inputArray) {
		 Arrays.sort(inputArray);
		 return inputArray;
	}

	/**
	 * generic print Array
	 * @param inputArray
	 */
	public static <E> void printArray(E[] inputArray) {
		// Display array elements
		for (E element : inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}
	
	public int maxSubArray(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (sum < 0) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}

			maxSum = Math.max(sum, maxSum);
		}

		return maxSum > sum ? maxSum : sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Integer[] intArray = { 1, 2, 3, 4, 5 };
	      Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
	      Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

	      System.out.println("Array integerArray contains:");
	      printArray(intArray);   // pass an Integer array

	      System.out.println("\nArray doubleArray contains:");
	      printArray(doubleArray);   // pass a Double array

	      System.out.println("\nArray characterArray contains:");
	      printArray(charArray);   // pass a Character array
	      
	      ArrayHelper a = new ArrayHelper();
	      int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
	      System.out.println(a.maxSubArray(nums));
	}

}
