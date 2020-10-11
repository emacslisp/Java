package com.dw.leetcode;

// https://leetcode.com/contest/weekly-contest-210/problems/maximum-nesting-depth-of-the-parentheses/
public class MaximumNestingDepthoftheParentheses_5535 {
	
	public int maxDepth(String s) {
		if(s.length() == 0) return 0;
		
		if(s.length() == 1) {
			char c = s.charAt(0);
			
			if(c!='(' || c!=')') {
				return 0;
			}
		}
		
		int depth = 0;
		int maxDepth = 0;
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c=='(') {
				depth++;
			}
			
			if(c==')') {
				depth--;
			}
			
			if(depth > maxDepth) {
				maxDepth = depth;
			}
		}
		
		return maxDepth;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumNestingDepthoftheParentheses_5535 s  = new MaximumNestingDepthoftheParentheses_5535();
		String x = "1+(2*3)/(2-1)";
		int result = s.maxDepth(x);
		System.out.println(result);
	}

}
