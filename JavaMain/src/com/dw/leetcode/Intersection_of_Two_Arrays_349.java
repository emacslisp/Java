package com.dw.leetcode;

import java.util.*;

//@example: Leetcode - 349. Intersection of Two Arrays  - https://leetcode.com/problems/intersection-of-two-arrays/#/description
public class Intersection_of_Two_Arrays_349 {
	public static int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> result = new ArrayList<Integer>();
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<nums1.length;i++) {
			map.put(nums1[i],0);
		}
		
		for(int i=0;i<nums2.length;i++) {
			Integer temp = map.get(nums2[i]);
			if(temp!=null && temp == 0) {
				result.add(nums2[i]);
				map.put(nums2[i],1);
			}
		}
		
		int[] resultArray = new int[result.size()];
		for(int i=0;i < resultArray.length;i++) {
			resultArray[i] = result.get(i);
		}
		return resultArray;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1 = {1, 2, 2, 1};
		int[] test2 = {2,2};
		
		int[] result = intersection(test1,test2);
		
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
		
	}
}
