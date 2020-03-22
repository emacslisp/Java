package com.dw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/contest/weekly-contest-181/problems/check-if-there-is-a-valid-path-in-a-grid/
public class CheckThereIsValidPathInGrid_5366 {
	class pair {
		public int x;
		public int y;
		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public boolean hasValidPath(int[][] grid) {
		int[][] visit = new int[grid.length][grid[0].length];
        HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
        int m = grid[0].length;
        int n = grid.length;
        for(int i=1;i<=6;i++) {
        	if(i==1) {
        		map.put(i, new int[] {1, 0, 1, 0});
        	}
        	if(i==2) {
        		map.put(i, new int[] {0, 1, 0, 1});
        	}
        	if(i==3) {
        		map.put(i, new int[] {1, 0, 0, 1});
        	}
        	if(i==4) {
        		map.put(i, new int[] {0, 0, 1, 1});
        	}
        	if(i==5) {
        		map.put(i, new int[] {1, 1, 0, 0});
        	}
        	if(i==6) {
        		map.put(i, new int[] {0, 1, 1, 0});
        	}
        }
        
        Queue<pair> queue = new LinkedList<pair>();
        
        queue.offer(new pair(0,0));
        
        while(!queue.isEmpty()) {
        	pair point = queue.poll();
        	
        	visit[point.x][point.y] = 1;
        	if(point.x == n - 1 && point.y == m-1) {
        		return true;
        	}
        	
        	int[] checkStart = map.get(grid[point.x][point.y]);
        	
        	if(point.x - 1 >= 0 && visit[point.x - 1][point.y] == 0) {
        		int type = grid[point.x - 1][point.y];
        		int[] checkEnd = map.get(type);
        		
        		if(checkStart[1] == 1 && checkEnd[3] == 1) {
        			queue.offer(new pair(point.x - 1, point.y));
        		}
        	}
        	
        	if(point.x + 1 < n && visit[point.x + 1][point.y] == 0) {
        		int type = grid[point.x+1][point.y];
        		int[] checkEnd = map.get(type);
        		
        		if(checkStart[3] == 1 && checkEnd[1] == 1) {
        			queue.offer(new pair(point.x + 1, point.y));
        		}
        	}
        	
        	if(point.y - 1 >= 0 && visit[point.x][point.y - 1] == 0) {
        		int type = grid[point.x][point.y - 1];
        		int[] checkEnd = map.get(type);
        		
        		if(checkStart[0] == 1 && checkEnd[2] == 1) {
        			queue.offer(new pair(point.x, point.y - 1));
        		}
        	}
        	
        	if(point.y + 1 < m && visit[point.x][point.y + 1] == 0) {
        		int type = grid[point.x][point.y+1];
        		int[] checkEnd = map.get(type);
        		
        		if(checkStart[2] == 1 && checkEnd[0] == 1) {
        			queue.offer(new pair(point.x, point.y + 1));
        		}
        	}
        }
        
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckThereIsValidPathInGrid_5366 s= new CheckThereIsValidPathInGrid_5366();
		int[][] grid = {
				{1,1,2}
		};
		System.out.println(s.hasValidPath(grid));
	}

}
