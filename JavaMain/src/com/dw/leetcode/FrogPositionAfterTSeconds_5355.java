package com.dw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class FrogPositionAfterTSeconds_5355 {
	int levelTo = 0;
	int parentNode = 0;
	LinkedList<Integer> list = new LinkedList<Integer>();
	
    public double frogPosition(int n, int[][] edges, int t, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
        for(int i=0;i<edges.length;i++) {
    		if(map.get(edges[i][0]) == null) {
    			map.put(edges[i][0], new ArrayList<Integer>());
    		}
    		
    		 ArrayList<Integer> nodes = map.get(edges[i][0]);
    		 nodes.add(edges[i][1]);
        }
        
        Stack<Integer> stack = new Stack<>();
        dfs(map, 1, target, 0, stack);
        if(levelTo > t) return 0;
        
        System.out.println(levelTo);
        System.out.println(parentNode);
        

        
        return result;
    }
    
    
	void dfs (HashMap<Integer, ArrayList<Integer>> map, int root, int target, int level,  Stack<Integer> stack) {
		if(map.get(root) == null) {
			return;
		}
		
		if(root == target) {
			levelTo = level;
		}
		
		ArrayList<Integer> nodes = map.get(root);
		
		for(int p : nodes) {
			
			if(p == target) {
				parentNode = root;
				levelTo = level + 1;
				return;
			}
			
			dfs(map, p, target, level + 1, stack);
		}
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = {
				{1, 2},
				{1, 3},
				{1, 7},
				{2, 4},
				{2, 6},
				{3, 5},
		};
		
		int n = 7;
		int t = 2;
		int target = 4;
		
		FrogPositionAfterTSeconds_5355 s = new FrogPositionAfterTSeconds_5355();
		
		s.frogPosition(n, edges, t, target);
	}

}
