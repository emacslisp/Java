package com.dw.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/contest/weekly-contest-207/problems/maximum-non-negative-product-in-a-matrix/
public class MaximumNonNegativeProductinaMatrix_5521 {
	long max = Long.MIN_VALUE;
	String path = "";
	
	public void dfsMaze(int x, int y, int[][] maze) {
		int m=maze.length;  
        int n=maze[0].length;  
        
        if (x < 0 || y < 0)  
            return;  
        if (x > m - 1 || y > n - 1)  
            return;  
        
        if (maze[x][y] == 0 || (x == m - 1 && y == n - 1)) {
        	String temp = path;
        	path = path + "" + x + "," + y + "";
        	String[] points = path.split("-");
        	long t = 1;
        	for(String point: points) {
        		String[] xy = point.split(",");
        		int tx = Integer.parseInt(xy[0]);
        		int ty = Integer.parseInt(xy[1]);
        		t *= maze[tx][ty];

        	}
        	
        	if(t > max) {
        		max = t;
        	}
        	path = temp;
            return;  
        }  
        
        String temp = path;  
        path = path + "" + x + "," + y + "" + "-"; // 记录路线   
        dfsMaze(x + 1, y, maze);  
        dfsMaze(x, y + 1, maze);  
        path = temp;  
	}
	
	public int maxProductPath(int[][] grid) {
		dfsMaze(0,0, grid);
		if(max < 0) return -1;
		
		return (int)(max%((int)Math.pow(10, 9) + 7));
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumNonNegativeProductinaMatrix_5521 s = new MaximumNonNegativeProductinaMatrix_5521();
		/*int[][] grid ={{2,1,3,0,-3,3,-4,4,0,-4},
				{-4,-3,2,2,3,-3,1,-1,1,-2},
				{-2,0,-4,2,4,-3,-4,-1,3,4},
				{-1,0,1,0,-3,3,-2,-3,1,0},
				{0,-1,-2,0,-3,-4,0,3,-2,-2},
				{-4,-2,0,-1,0,-3,0,4,0,-3},
				{-3,-4,2,1,0,-4,2,-4,-1,-3},
				{3,-2,0,-4,1,0,1,-3,-1,-1},
				{3,-4,0,2,0,-2,2,-4,-2,4},
				{0,4,0,-3,-4,3,3,-1,-2,-2}};*/
		
		int[][] grid = {{1,-1,2,1,-1,0,0,4,3,2,0,-2,-2},
				{-2,3,3,-1,-1,0,0,-2,4,-3,3,0,0},
				{-4,-1,-1,-2,2,-1,-2,-2,0,3,-1,-4,1},
				{-3,4,-3,0,-3,1,-3,1,4,4,-4,-4,-2},
				{3,-3,1,0,-1,-4,-4,-4,3,2,2,3,3},
				{2,-1,-1,-4,-3,-3,4,2,3,4,4,-4,0},
				{4,-1,2,-3,-1,-1,-3,-4,4,4,4,-3,-1},
				{-3,-4,4,-2,-1,2,3,-1,2,3,4,4,-4},
				{-3,-1,-2,1,1,-1,-3,-4,-3,1,-3,3,-4},
				{2,4,4,4,-3,-3,1,-1,3,4,-1,1,4},
				{2,-2,0,4,-1,0,-2,4,-4,0,0,2,-3},
				{1,1,-3,0,-4,-4,-4,-4,0,-1,-4,-1,0},
				{3,-1,-3,-3,-3,-2,-1,4,-1,-2,4,2,3}};
		
		System.out.println(s.maxProductPath(grid));
	}

}
