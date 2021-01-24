package com.dw.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindKthLargestXORCoordinateValue_5663 {
	public int kthLargestValue(int[][] matrix, int k) {
		int[][] t = new int[matrix.length + 1][matrix[0].length + 1];
		int[] result = new int[matrix.length * matrix[0].length];
		for(int i=0;i<t.length;i++) {
			t[i][0] = 0;
		}
		
		for(int i=0;i<t[0].length;i++) {
			t[0][i] = 0;
		}
		for(int i=1;i<=matrix.length;i++) {
			for(int j=1;j<=matrix[0].length;j++) {
				t[i][j] = t[i][j-1] ^ matrix[i-1][j-1];
			}
		}
		
		for(int i=1;i<=matrix.length;i++) {
			for(int j=1;j<=matrix[0].length;j++) {
				t[i][j] = t[i][j] ^ t[i-1][j];
			}
		}
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				result[i*matrix[0].length + j] = t[i+1][j+1];
			}
		}
		Arrays.sort(result);
		return result[result.length - k];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{10,9,5},{2,0,4},{1,0,9},{3,4,8}};
		int k = 10;
		FindKthLargestXORCoordinateValue_5663 s= new FindKthLargestXORCoordinateValue_5663();
		int result = s.kthLargestValue(matrix, k);
		System.out.println(result);
	}
}
