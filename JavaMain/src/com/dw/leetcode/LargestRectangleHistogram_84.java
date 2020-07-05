package com.dw.leetcode;

// https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleHistogram_84 {
	public int largestRectangleArea(int[] heights) {
		int result = 0;
		for(int i=0;i<heights.length;i++) {
			int minHeight = heights[i];
			
			if(result < minHeight) {
				result = minHeight;
			}
			
			for(int l=i+1;l<heights.length;l++) {
				if (minHeight > heights[l]) {
					minHeight = heights[l];
				}
				
				int area = minHeight *(l-i+1);
				if(result < area) {
					result = area;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {1};
		LargestRectangleHistogram_84 s = new LargestRectangleHistogram_84();
		System.out.println(s.largestRectangleArea(heights));
	}
}
