package com.dw.leetcode;

import java.util.Stack;

public class ValidateStackSequences_946 {

	public boolean validateStackSequences(int[] pushed, int[] popped) {
		if(popped.length == 0) return true;
		Stack<Integer> stack = new Stack<Integer>();
		int index = 0;
		int i = 0;
		while(true) {
			if(stack.size() == 0) {
				stack.push(pushed[i++]);
				continue;
			}
			
			if(stack.peek() == popped[index]) {
				stack.pop();
				index++;
			} else {
				
				if(i >= pushed.length) break;
				
				stack.push(pushed[i++]);
			}
			
			if(index >= popped.length) {
				break;
			}
		}
		
		System.out.println(index);
		System.out.println(i);
		
		if(stack.size() == 0) return true;
		
		return false;
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidateStackSequences_946 v = new ValidateStackSequences_946();
		int[] pushed = {1,2,3,4,5};
		int[] popped = {4,3,5,1,2};
		boolean result = v.validateStackSequences(pushed, popped);
		System.out.println(result);
	}

}
