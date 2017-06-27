package com.dw.leetcode;

import com.dw.googlecodejam.googlecodejam_2017_Round1_C1.s;

public class Number_of_Islands_200 {
	
	private int n;
	private int m;
	
    public int numIslands(char[][] grid) {
    	
    	if(grid == null) return 0;
    	
    	if(grid.length == 0) return 0;
    	
    	n = grid.length;
    	m = grid[0].length;
    	int counter = 0;
    	for(int i=0;i<n;i++)
    		for(int j=0;j<m;j++) {
    			if(grid[i][j] == '1') {
    				DFS(grid, i,j);
    				counter++;
    			}
    		}
    	
    	return counter;
    }
    
    public void DFS(char[][] grid, int i,int j) {
    	if(i<0 || i >=n || j<0 || j >=m || grid[i][j] != '1') return ;
    	grid[i][j] = '0';
    	DFS(grid, i-1, j);
    	DFS(grid, i+1, j);
    	DFS(grid, i, j-1);
    	DFS(grid, i, j+1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*char[][] grid = {{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}};*/
		
		char[][] grid = {};
		
		Number_of_Islands_200 s = new Number_of_Islands_200();
		
		System.out.println(s.numIslands(grid));
	}

}

