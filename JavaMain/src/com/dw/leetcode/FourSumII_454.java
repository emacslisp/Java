package com.dw.leetcode;

import java.util.*;

public class FourSumII_454 {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int result = 0;
		
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<B.length;j++) {
				int sum = A[i] + B[j];
				if(map.containsKey(sum)) {
					map.put(sum, map.get(sum) + 1);
				} else {
					map.put(sum, 1);
				}
			}
		}
		
		for(int i=0;i<C.length;i++) {
			for(int j=0;j<D.length;j++) {
				int sum = -( C[i] + D[j]);
				if(map.containsKey(sum)) {
					result += map.get(sum);
				}
			}
		}
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 2};
		int[] B = {-2,-1};
		int[] C = {-1, 2};
		int[] D = { 0, 2};
		FourSumII_454 s = new FourSumII_454();
		int result = s.fourSumCount(A, B, C, D);
		System.out.println(result);
	}

}
