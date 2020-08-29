package com.dw.lib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexService {
	public RegexService() {
		
	}
	
	/**
	 * check all string with a-z and A-Z
	 * @param input
	 * @return
	 */
	public boolean isAllLetterAndNumber(String input) {
		Pattern p = Pattern.compile("[a-zA-Z0-9]+");
		Matcher m = p.matcher(input);  
		boolean b = m.matches();  
		return b;
	}
	
	//             System.out.println("Counting down ...");
	public static void main(String[] args) {
		
		String s = "       System.out.println(\"Counting down ...\");";
		Pattern pattern = Pattern.compile("System");
		Matcher m = pattern.matcher(s);
		if (m.find()) {
			System.out.println("matches");
		}
		
	}
}
