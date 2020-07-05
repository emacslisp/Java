package com.dw.leetcode;

// https://leetcode.com/problems/maximal-rectangle/
public class MaximalRectangle_85 {

	public int maximalRectangle(char[][] mat) {
		if(mat.length == 0) return 0;
		
		int[][] matrix = new int[mat.length][mat[0].length];
		int m = matrix.length, n = matrix[0].length, res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = mat[i][j] - '0';
			}
		}

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				// matrix stores num of consecutive ones from matrix[i][j] first zero on its
				// right
				matrix[i][j] = matrix[i][j] == 0 ? 0 : matrix[i][j] + matrix[i][j + 1];
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				int min = matrix[i][j];
				
				if (res < min) {
					res = min;
				}

				for (int k = i + 1; k < m; k++) {
					if (matrix[k][j] == 0)
						break;
					min = Math.min(min, matrix[k][j]);
					if (res < min*(k-i + 1)) {
						res = min*(k-i+1);
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximalRectangle_85 s = new MaximalRectangle_85();
		char[][] mat = {
				  {'1'}
				};
		System.out.println(s.maximalRectangle(mat));
	}

}
