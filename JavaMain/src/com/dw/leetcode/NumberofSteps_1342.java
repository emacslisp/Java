package com.dw.leetcode;

public class NumberofSteps_1342 {
	public int numberOfSteps (int num) {
		int n = num;
		
		int step = 0;
		while (n > 0) {
			if (n%2 == 0) {
				n = n/2;
			}
			else {
				n = (n-1);
			}
			step++;
		}
		
		return step;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofSteps_1342 s = new NumberofSteps_1342();
		System.out.println(s.numberOfSteps(8));
	}

}
