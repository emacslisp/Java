package com.dw.leetcode;

import java.util.*;

public class ReverseSubstringsBetweenEachPairofParentheses_1190 {
	
	String revert(String s, int offset) {
		Stack<Character> st = new Stack<>();
		Queue<Character> qu = new LinkedList<Character>();
		
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			
			if(c == ')') {
				while(!st.isEmpty()) {
					char tc = st.pop();
					
					if(tc == '(') break;
					
					qu.add(tc);
				}
				
				while(!qu.isEmpty()) {
					st.push(qu.poll());
				}
			} else {
				st.push(c);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		
		return sb.reverse().toString();
	}
	
	public String reverseParentheses(String s) {
		
		String t = revert(s, 0);
		return t;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseSubstringsBetweenEachPairofParentheses_1190 s= new ReverseSubstringsBetweenEachPairofParentheses_1190();
		String input = "(ed(et(oc))el)";
		String result = s.reverseParentheses(input);
		System.out.println(result);
	}

}
