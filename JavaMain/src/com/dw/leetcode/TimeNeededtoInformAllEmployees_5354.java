package com.dw.leetcode;

import java.util.*;

public class TimeNeededtoInformAllEmployees_5354 {
	int max = 0;
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {	
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		
		for (int i=0;i<manager.length;i++) {
			if(map.get(manager[i]) == null) {
				map.put(manager[i], new ArrayList<Integer>());
			}
			
			map.get(manager[i]).add(i);
		}
		
		dfs(map, headID, informTime[headID], informTime);		
		
		return max;
    }
	
	void dfs (HashMap<Integer, ArrayList<Integer>> map, int root, int value, int[] informTime) {
		if(map.get(root) == null) {
			if(value > max)
				max = value;
			return;
		}
		
		ArrayList<Integer> level = map.get(root);
		
		for(int p : level) {
			dfs(map, p, value + informTime[p], informTime);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int manager[] = {3,3,-1,2};
		int informTime[] = {0,0,162,914};
		int n = 4;
		int headID = 2;
		
		TimeNeededtoInformAllEmployees_5354 s= new TimeNeededtoInformAllEmployees_5354();
		System.out.println(s.numOfMinutes(n, headID, manager, informTime));
	}

}
