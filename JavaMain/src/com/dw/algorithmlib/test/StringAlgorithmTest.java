package com.dw.algorithmlib.test;

import com.dw.algorithmlib.StringAlgorithm;

public class StringAlgorithmTest {

	public static void main(String[] args) {
		StringAlgorithm sa = new StringAlgorithm();
		System.out.println(sa.isPalindrom("abc121cba"));
		System.out.println(sa.isPalindrom("abc11cba"));
		System.out.println(sa.isPalindrom("a"));
	}

}
