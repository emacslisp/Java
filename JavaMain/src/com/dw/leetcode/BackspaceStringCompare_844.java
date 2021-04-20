package com.dw.leetcode;

import java.util.Stack;

public class BackspaceStringCompare_844 {
	
	public String filterString(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c == '#') {
				if(stack.size() > 0) {
					stack.pop();
				}
			} else
			stack.add(s.charAt(i));
		}
		
		StringBuilder sb = new StringBuilder();
		while(stack.size() > 0) {
			sb.append(stack.pop());
		}
		
		return sb.reverse().toString();
	}
	
	public boolean backspaceCompare(String s, String t) {
		
		
		
		String s1 = filterString(s);
		String s2 = filterString(t);
		System.out.println(s1);
		System.out.println(s2);
		
		return s1.equals(s2);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackspaceStringCompare_844 o= new BackspaceStringCompare_844();
		String s = "a##c";
		String t = "#a#c";
		boolean result = o.backspaceCompare(s, t);
		System.out.println(result);
	}

}
