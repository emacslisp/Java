package com.dw.lispmachine;

import java.util.ArrayList;
import java.util.List;

public class TokenLex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "(add 1.2 2 3 (+ 4.5 5))";
		if (checkValidSExp(input)) {
			List<Token> tokens = tokenString(input);
			int level = 0;
			int start = 0;
			SExp mainExp = null;
			for(Token t : tokens) {
				System.out.println(t.getType() + " " + t.getValue());
			}
			
			Token[] tokensArray = (Token[]) tokens.toArray();
			
			for(int i=0;i<tokensArray.length; i++) {
				
			}
			
			/*
			//tokens.toArray();
			for(Token t : tokens) {
				if (start == 1) {
					mainExp = new SExp(t.getValue(), new ArrayList<SExp>());
					counterLeft = -1;
					continue;
				}
				
				if (t.getType() == TokenType.LeftBrack) {
					start = 1;
					level++;
				}
				
				if (t.getType() == TokenType.RightBrack) {
					level--;
				}
				
				if (counterLeft == -1) {
					if (t.getType() == TokenType.Number) 
						mainExp.variable.add(new SExp(SType.Float, t.getValue()));
				}
			}*/
		}
		System.out.println();
	}
	
	private static boolean tokenStop(char c) {
		switch (c) {
		case ' ':
		case '\t':
		case '\n':
			return true;
		default:
			return false;
		}
	}
	
	private static List<Token> tokenString(String input) {
		List<Token> tokens = new ArrayList<Token>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			
			if ((c - 'a' >= 0 && c - 'z' <=0) ||
					(c-'A'>=0 && c-'Z'<=0)) {
				int start = i;
				int stop = parseStringToken(input, start);
				tokens.add(new Token(TokenType.String, input.substring(start, stop)));
				i = stop;
			}
			
			switch (input.charAt(i)) {
			case ' ':
			case '\n':
				continue;
				
			case '+':
				tokens.add(new Token(TokenType.Add, "+"));
				continue;
				
			case '-':
				tokens.add(new Token(TokenType.Sub, "-"));
				continue;
				
			case '(':
				tokens.add(new Token(TokenType.LeftBrack, "("));
				break;
			case ')':
				tokens.add(new Token(TokenType.RightBrack, ")"));
				break;
				
			case '1': case '2': case '3': case '4': case '5':
			case '6': case '7': case '8': case '9': case '0':
			case '.':
				// try to parse Number token here
				int start = i;
				int stop = parseNumberToken(input, start);
				tokens.add(new Token(TokenType.Number, input.substring(start, stop)));
				i = stop;
				break;
			}
		}

		return tokens;
	}

	private static int parseNumberToken(String input, int start) {
		int target = start;
		int dotCounter = 0;
		for(;target<input.length();target++) {
			char c = input.charAt(target);
			if (tokenStop(c)) {
				return target;
			}
			
			if (c - '0' <= 9 && c - '0' >= 0) {
				continue;
			}
			
			if(c == '.' && dotCounter == 0) {
				continue;
			}
			else {
				return target;
			}
		}
		return target;
	}

	private static int parseStringToken(String input, int index) {
		int target = index;
		for(;target<input.length();target++) {
			char c = input.charAt(target);
			if (tokenStop(c)) {
				return target;
			}
		}
		return target;
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
