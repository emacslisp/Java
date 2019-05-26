package com.dw.lib;

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
}
