package com.dw.leetcode;

// https://leetcode.com/contest/weekly-contest-196/problems/count-submatrices-with-all-ones/
public class CountSubmatricesWithAllOnes_5454 {
	public int numSubmat(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, res = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                // matrix stores num of consecutive ones from matrix[i][j] first zero on its right
                matrix[i][j] = matrix[i][j] == 0 ? 0 : matrix[i][j] + matrix[i][j + 1];
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
            	System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = matrix[i][j];
                System.out.println("min 1: " + min + "\t");
                res += min;
                for (int k = i + 1; k < m; k++) {
                    if (matrix[k][j] == 0) break;
                    min = Math.min(min, matrix[k][j]);
                    System.out.println("min 2: " + min + "\t");
                    res += min;
                }
            }
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{1, 0, 1},
				 {1, 1, 0},
				 {1, 1, 0}};
		
		CountSubmatricesWithAllOnes_5454 s = new CountSubmatricesWithAllOnes_5454();
		System.out.println(s.numSubmat(mat));
	}

}
