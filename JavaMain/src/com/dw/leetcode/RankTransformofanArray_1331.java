package com.dw.leetcode;
import java.util.*;

public class RankTransformofanArray_1331 {
	public int[] arrayRankTransform(int[] arr) {
		if(arr.length == 0) return arr;
		if(arr.length == 1) return new int[] {1};
		
		int[] copyArr = Arrays.copyOf(arr, arr.length);
		int[] result = new int[arr.length];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		Arrays.sort(arr);
		
		int index = 1;
		int previous = arr[0];
		map.put(arr[0], 1);
		
        for(int i=1;i<arr.length;i++) {
        	if(arr[i] == previous) {
        		
        	} else {
        		previous = arr[i];
        		index++;
        		map.put(arr[i], index);
        	}
        }
        
        for(int i = 0;i< arr.length;i++) {
        	result[i] = map.get(copyArr[i]);
        }
        
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RankTransformofanArray_1331 s = new RankTransformofanArray_1331();
		int[] arr = {100, 100, 100};
		int[] result = s.arrayRankTransform(arr);
		for(int x: result) {
			System.out.print(x + "\t");
		}
		System.out.println();
	}

}
