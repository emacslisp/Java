package com.dw.leetcode;

public class FlippinganImage_832 {

	public int[][] flipAndInvertImage(int[][] A) {
		int m = A.length;
		int n = A[0].length;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n/2;j++) {
				int t = A[i][j];
				A[i][j] = A[i][n - j - 1];
				A[i][n - j - 1] = t;
			}
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(A[i][j] == 0) A[i][j] = 1;
				else if(A[i][j] == 1) A[i][j] = 0;
			}
		}
		
		return A;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] A = {
				{1, 1, 0, 0},
				{1, 0, 0, 1},
				{0, 1, 1, 1}, 
				{1, 0, 1, 0}
		};
		
		FlippinganImage_832 s = new FlippinganImage_832();
		int[][] result = s.flipAndInvertImage(A);
		int m = A.length;
		int n = A[0].length;
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

}
