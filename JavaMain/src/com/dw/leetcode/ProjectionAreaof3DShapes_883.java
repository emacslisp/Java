package com.dw.leetcode;

public class ProjectionAreaof3DShapes_883 {
	
    public int projectionArea(int[][] grid) {
        int result = 0;
        
        for(int i=0;i<grid.length;i++) {
        	for(int j=0;j<grid[0].length;j++) {
        		if(grid[i][j] > 0) {
        			result += 1;
        		}
        	}
        }
        
        for(int i=0;i<grid.length;i++) {
        	int max = 0;
        	for(int j=0;j<grid[0].length;j++) {
        		if(max < grid[i][j]) {
        			max = grid[i][j];
        		}
        	}
        	
        	result += max;
        }
        
        for(int j=0;j<grid[0].length;j++) {
        	int max = 0;
        	for(int i=0;i<grid.length;i++) {
        		if(max < grid[i][j]) {
        			max = grid[i][j];
        		}
        	}
        	result += max;
        }
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProjectionAreaof3DShapes_883 s = new ProjectionAreaof3DShapes_883();
		int[][] grid = {{2,2,2},{2,1,2},{2,2,2}};
		int result = s.projectionArea(grid);
		System.out.println(result);
	}

}
