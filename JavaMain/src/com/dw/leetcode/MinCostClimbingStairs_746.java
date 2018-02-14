package com.dw.leetcode;

public class MinCostClimbingStairs_746 {
	
	public static int minCostClimbingStairs(int[] cost) {
		if(cost.length == 1) return 0;
		if(cost.length == 2) return Math.min(cost[0], cost[1]);
        
        int[] array = new int[cost.length];
        
        array[0]=cost[0];
        
        array[1] = cost[1];
        
        for(int i=2;i<array.length;i++) {
        	array[i] = Math.min(cost[i]+array[i-1], cost[i]+array[i-2]);
        }
        
        return Math.min(array[array.length-1], array[array.length-2]);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(minCostClimbingStairs(cost));
	}

}
