package com.dw.lib;

import java.io.UnsupportedEncodingException;

public class StringService {
	StringBuilder sb = new StringBuilder();
	public StringService() {
		
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
}
