package com.dw.leetcode;

import java.util.Stack;

public class DesignStackWithIncrementOperation_5357 {
	static class CustomStack {
		int[] stack;
		int index = 0;
	    public CustomStack(int maxSize) {
	    	stack = new int[maxSize];
	    }
	    
	    public void push(int x) {
	        if(index < stack.length) {
	        	stack[index] = x;
	        	index++;
	        }
	    }
	    
	    public int pop() {
	    	if(index > 0) {
	    		index--;
	    		return stack[index];
	    	}
	    	
	    	return -1;
	    }
	    
	    public void increment(int k, int val) {
	    	for(int i=0;i<stack.length && i<k;i++) {
	    		stack[i] += val;
	    	}
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomStack customStack = new CustomStack(3);
		customStack.push(1);
		customStack.push(2);
		customStack.pop();
		customStack.push(2);
		customStack.push(3);
		customStack.push(4);
		customStack.increment(5, 100);
		customStack.increment(2, 100);
		System.out.println(customStack.pop());
		System.out.println(customStack.pop());
		System.out.println(customStack.pop());
		System.out.println(customStack.pop());
	}

}
