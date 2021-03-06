package com.dw.lib;

import java.io.UnsupportedEncodingException;

public class StringUtils {
	StringBuilder sb = new StringBuilder();
	public StringUtils() {
		
	}
	
	public StringBuilder appendLine(String s) {
		sb.append(s);
		sb.append(System.lineSeparator());
		return sb;
	}
	
	public StringBuilder append(String s) {
		sb.append(s);
		return sb;
	}
	
	public boolean startsWith(String s, String start) {
		return s.startsWith(start);
	}
	
	public String toString() {
		return sb.toString();
	}
	
	public static String StringToUTF8(String s) {
		byte ptext[] = s.getBytes();
		String value;
		try {
			value = new String(ptext, "UTF-8");
			return value;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	public static void main(String[] args) {
		String s = "ABABAB";
		String s2 = "ABAB";
		System.out.println(s.substring(s2.length()));
	}
}
