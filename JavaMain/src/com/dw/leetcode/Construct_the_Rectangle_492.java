package com.dw.leetcode;


//@example: Leetcode - 492. Construct the Rectangle - https://leetcode.com/problems/construct-the-rectangle/#/description
public class Construct_the_Rectangle_492 {
	public static int[] constructRectangle(int area) {
		int[] result = new int[2];
		int maxDiff = Integer.MAX_VALUE;
		for(int i=area;i>=Math.sqrt(area);i--)
		{
			if(area%i == 0)
			{
				int L = i;
				int W = area/i;
				
				if(maxDiff > (L-W) && (L-W) >= 0)
				{
					maxDiff = L-W;
					result[0]=L;
					result[1]=W;
				}
			}
		}
		
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = constructRectangle(1);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

}
