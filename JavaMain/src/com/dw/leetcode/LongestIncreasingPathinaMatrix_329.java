package com.dw.leetcode;

public class LongestIncreasingPathinaMatrix_329 {
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix.length == 0) return 0;
        int max = 0;
        int m= matrix.length;int n= matrix[0].length;
        int[][] cache = new int[m][n];
        
        for(int i=0;i<m;i++)
        	for(int j=0;j<n;j++) {
        		int len = dfs(matrix,i,j,cache);
        		if(len > max) max = len;
        	}
        
        return max;
    }
	
	public int dfs(int[][] matrix,int i, int j, int[][] cache) {
		if(cache[i][j] != 0 ) return cache[i][j];
		
		int t_max = 1;
		
		if(i>0 && matrix[i][j] < matrix[i-1][j]) {
			int t = 1 + dfs(matrix, i-1, j, cache);
			if(t > t_max) t_max = t;
		}
		
		if(j>0 && matrix[i][j] < matrix[i][j-1]) {
			int t = 1 + dfs(matrix, i, j-1, cache);
			if(t > t_max) t_max = t;
		}
		
		if(i+1 <matrix.length && matrix[i][j] < matrix[i+1][j]) {
			int t = 1 + dfs(matrix, i+1, j, cache);
			if(t > t_max) t_max = t;
		}
		
		if(j+1 <matrix[0].length && matrix[i][j] < matrix[i][j+1]) {
			int t = 1 + dfs(matrix, i, j+1, cache);
			if(t > t_max) t_max = t;
		}
		
		cache[i][j]=t_max;
		
		return t_max;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				  {3,4,5},
				  {3,2,6},
				  {2,2,1}
		};
		
		LongestIncreasingPathinaMatrix_329 s = new LongestIncreasingPathinaMatrix_329();
		System.out.println(s.longestIncreasingPath(matrix));
		
		
	}

}
