package com.dw.leetcode;

public class GoalParserInterpretation_5617 {

	public String interpret(String command) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<command.length();i++) {
			char c = command.charAt(i);
			
			if(c=='G') {
				sb.append('G');
			}
			
			if (c=='(') {
				char d = command.charAt(i+1);
				if(d==')') {
					sb.append('o');
				} else if(d=='a') {
					char e = command.charAt(i+2);
					char f = command.charAt(i+3);
					if(e=='l' && f== ')') {
						sb.append("al");
					}
				}
			}
		}
		
		return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoalParserInterpretation_5617 s= new GoalParserInterpretation_5617();
		String result = s.interpret("G()()()()(al)");
		System.out.println(result);
	}

}
