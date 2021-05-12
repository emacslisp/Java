package com.dw.algorithmlib.test;

import com.dw.algorithmlib.StringHelper;

public class StringAlgorithmTest {

	public static void main(String[] args) {
		StringHelper sa = new StringHelper();
		System.out.println(sa.isPalindrom("abc121cba"));
		System.out.println(sa.isPalindrom("abc11cba"));
		System.out.println(sa.isPalindrom("a"));
	}

}
