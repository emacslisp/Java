package com.dw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimum_Absolute_Difference_1200 {

	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		
		Arrays.sort(arr);
		
		int minInteval = arr[arr.length - 1] - arr[0];
		
		for(int i=0;i<arr.length - 1;i++) {
			if((arr[i+1] - arr[i])<minInteval) {
				minInteval = (arr[i+1] - arr[i]);
			}
		}
		
		for(int i=0;i<arr.length - 1;i++) {
			if((arr[i+1] - arr[i]) == minInteval) {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(arr[i]);
				temp.add(arr[i+1]);
				result.add(temp);
			}
		}
		
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {188,9,-189,-112,165,4,-141,179,-154,258,53,71,201,204,121,215,259,-22,34,-213,-88,-192,118,-221,130,-86,209};
		
		Minimum_Absolute_Difference_1200 s = new Minimum_Absolute_Difference_1200();
		List<List<Integer>> result = s.minimumAbsDifference(array);
		for(List<Integer> t : result) {
			for(Integer i: t) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
