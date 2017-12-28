package com.dw.leetcode;

public class MyCalendar {
	public static class IntervalTree {
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
	IntervalTree root;
	IntervalTree current;
    public MyCalendar() {
        root = null;
        current = root;
    }
    
    public boolean book(int start, int end) {
    	current = root;
        return foo(new IntervalTree(start,end));
    }
    
    public boolean foo(IntervalTree target) {
    	if(root == null) {
    		root = new IntervalTree(target.start,target.end);
        	return true;
        }
    	
    	if(current == null) {
    		current = new IntervalTree(target.start,target.end);
        	return true;
        }
    	
    	if(current.start >= target.end) {
    		if(current.left == null) {
    			current.left = new IntervalTree(target.start,target.end);
    			return true;
    		}
    		
    		current = current.left;
    		return foo(target);
    	}
    	else if(current.end <= target.start) {
    		if(current.right == null) {
    			current.right = new IntervalTree(target.start,target.end);
    			return true;
    		}
    		current = current.right;
    		return foo(target);
    	}
    	else if(current.start>=target.start && current.end<=target.end) {
    		return false;
    	}
    	else if(current.start<=target.start && current.end>=target.end) {
    		return false;
    	}
    	else if(current.start>=target.start && current.start<=target.end) {
    		return false;
    	}
    	else if(current.end>=target.start && current.end<=target.end) {
    		return false;
    	}
    	
    	return false;
    }
}