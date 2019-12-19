package com.dw.leetcode;

public class minimum_time_visiting_all_points_1266 {

	public int minTimeToVisitAllPoints(int[][] points) {
		int result = 0;
		
		for(int i=0;i<points.length - 1;i++) {
			result += Math.max(Math.abs(points[i][0] - points[i+1][0]), Math.abs(points[i][1] - points[i+1][1]));
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = {{1,1},{3,4},{-1,0}};
		minimum_time_visiting_all_points_1266 s = new minimum_time_visiting_all_points_1266();
		System.out.println(s.minTimeToVisitAllPoints(points));
	}
}
