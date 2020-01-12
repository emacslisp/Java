package com.dw.leetcode;

public class Minimum_Distance_5310 {
	private int[] coordinate(char x) {
		int[] result = new int[2];
		
		int distance = x-'A';
		result[0] = distance%5;
		result[1] = distance/5 - 1;
		
		return result;
	}
	
	private int d(int[] x1, int[] x2) {
		return Math.abs(x1[0] - x2[0]) + Math.abs(x1[1] - x2[1]); 
	}
	
	public int minimumDistance(String word) {
		int result = 0;
		
		int[] distance = new int[word.length() -1 ];
		for(int i=0;i<word.length() - 1;i++) {
			int[] x1 = coordinate(word.charAt(i));
			int[] x2 = coordinate(word.charAt(i+1));
			distance[i] = d(x1, x2);
		}
		
		for(int i=0;i<distance.length;i++) {
			System.out.println(distance[i] + "\t");
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Minimum_Distance_5310 s= new Minimum_Distance_5310();
		s.minimumDistance("YEAR");
		
	}

}
