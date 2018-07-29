package com.dw.lib;

public class ArrayHelper {
	
	public char[] CopyArray(char[] a, char[] b) {
		System.arraycopy(a, 0, b, 0, a.length);
		return b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
