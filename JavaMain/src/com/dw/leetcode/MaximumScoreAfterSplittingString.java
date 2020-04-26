package com.dw.leetcode;

// https://leetcode.com/contest/weekly-contest-186/problems/maximum-score-after-splitting-a-string/
public class MaximumScoreAfterSplittingString {
	public int maxScore(String s) {
        int max = 0;
		for(int i=1;i<=s.length()-1;i++) {
			String left = s.substring(0,i);
			String right = s.substring(i, s.length());
			
			System.out.println(left);
			System.out.println(right);
			int cl = 0;
			int cr = 0;
			for(int j=0;j<left.length();j++) {
				if(left.charAt(j) == '0') {
					cl++;
				}
			}
			
			for(int j=0;j<right.length();j++) {
				if(right.charAt(j) == '1') {
					cr++;
				}
			}
			
			if (max < (cl+cr)) {
				max = cl+cr;
			}
		}
		return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "00";
		
		MaximumScoreAfterSplittingString x = new MaximumScoreAfterSplittingString();
		System.out.println(x.maxScore(s));
	}

}
