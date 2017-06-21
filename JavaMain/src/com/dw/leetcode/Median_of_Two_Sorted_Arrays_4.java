package com.dw.leetcode;

public class Median_of_Two_Sorted_Arrays_4 {
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
		double result = 0;
		int[] mergedArray = new int[nums1.length+nums2.length];
		
		int index1 = 0;
		int index2 = 0;
		int i=0;
		while(index1<nums1.length && index2<nums2.length) {
			mergedArray[i++] = nums1[index1] < nums2[index2]? nums1[index1]: nums2[index2];
			if(nums1[index1] < nums2[index2]) {
				index1++;
			}
			else
				index2++;
			
		}
		
		if(index1<nums1.length) {
			while(index1<nums1.length)
				mergedArray[i++]=nums1[index1++];
		}
		
		if(index2<nums2.length) {
			while(index2<nums2.length)
				mergedArray[i++]=nums2[index2++];
		}
		
		int len = mergedArray.length;
		
		if(len%2 == 0)
			result = ((double)(mergedArray[len/2 - 1] + mergedArray[len/2]))/(double)2;
		else
			result = mergedArray[len/2];
		
		return result;
    }

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] num1 = {1, 3};
		int[] num2 = {2, 4};
		System.out.println(findMedianSortedArrays(num1,num2));
	}

}
