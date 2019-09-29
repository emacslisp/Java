package com.dw.lispmachine;

import java.util.ArrayList;
import java.util.List;

public class TokenLex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "(+ 1 2 3 (+ 4 5))";
		
		System.out.println(checkValidSExp(input));
	}
	
	private static List<Token> tokenString(String input) {
		List<Token> tokens = new ArrayList<Token>();
		for (int i = 0; i < input.length(); i++) {
			switch (input.charAt(i)) {
			case ' ':
			case '\n':
				continue;
				
			case '(':
				break;

			}
		}

		return tokens;
	}

	private static boolean checkValidSExp(String input) {
		// TODO Auto-generated method stub
		boolean result = false;
		int counterLeft = 0;
		int counterRight = 0;
		for(int i = 0; i<input.length();i++) {
			char c = input.charAt(i);
			if (c == '(') {
				counterLeft++;
			} else if (c== ')') {
				counterRight++;
			}
		}
		return counterLeft > 0 && counterRight > 0 && counterLeft == counterRight;
	}

}
