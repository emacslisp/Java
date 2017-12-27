package com.dw.leetcode;

public  class IntervalTree {
	public int start;
	public int end;
	
	IntervalTree left;
	IntervalTree right;
	
	public IntervalTree() {
		
	}
	
	public IntervalTree(int start,int end) {
		this.start = start;
		this.end = end;
	}
}
