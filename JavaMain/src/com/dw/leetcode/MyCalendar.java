package com.dw.leetcode;

public class MyCalendar {
	IntervalTree root = null;
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        return foo(root, new IntervalTree(start,end));
    }
    
    public boolean foo(IntervalTree root,IntervalTree target) {
    	if(root == null) {
        	root = new IntervalTree(target.start,target.end);
        	return true;
        }
    	
    	if(root.start >= target.end) {
    		return foo(root.left, target);
    	}
    	else if(root.end <= target.start) {
    		return foo(root.right, target);
    	}
    	else if(root.start>=target.start && root.end<=target.end) {
    		return false;
    	}
    	else if(root.start<=target.start && root.end>=target.end) {
    		return false;
    	}
    	else if(root.start>=target.start && root.start<=target.end) {
    		return false;
    	}
    	else if(root.end>=target.start && root.end<=target.end) {
    		return false;
    	}
    	
    	return false;
    }
}