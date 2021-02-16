package com.dw.leetcode;
import java.util.*;

public class Shift2DGrid_1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    	int x = grid[0].length;
    	int y = grid.length;
    	
        int[] flatGrid = new int[x*y];
        
        for(int i=0;i<y;i++) {
        	for(int j=0;j<x;j++) {
        		flatGrid[i * x + j] = grid[i][j];
        	}
        }
        
        int index = flatGrid.length - k%flatGrid.length;
        int counter = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while(counter < flatGrid.length) {
        	List<Integer> r = new ArrayList<Integer>();
        	
        	for(int i=0;i<x;i++) {
        		r.add(flatGrid[index%flatGrid.length]);
        		index++;
        		counter++;
        	}
        	
        	result.add(r);
        }
        
        return result;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shift2DGrid_1260 s = new Shift2DGrid_1260();
		// int[][] grid = {{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
		int[][] grid = {{3},{19},{4},{12}};
		int k = 23;
		 List<List<Integer>> result = s.shiftGrid(grid, k);
		 for(List<Integer> r: result) {
			 for(Integer x: r) {
				 System.out.print(x + "\t");
			 }
			 System.out.println();
		 }
	}

}
