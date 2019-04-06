package com.dw.algorithmlib.test;

import com.dw.algorithmlib.MathHelper;
import java.util.*;

public class MathHelperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TestMathAdd(mathHelper);
		TestIsPrimer();
		generateData();
	}
	
	public static void generateData() {
		  int[] L= {9767,9769,9781,9787,9791,9803,9811,9817,9829,9833,9839,9851,9857,9859,9871,9883,9887,9901,9907,9923,9929,9931,9941,9949,9967,9973};
		  String input = "SUBDERMATOGLYPHICFJKNQVWXZSUBDERMATOGLYPHICFJKNQVWXZSUBDERMATOGLYPHICFJKNQVWXZSUBDERMATOGLYPHICFJKNQVWXZ";
		  for(int i=0;i<input.length() - 1;i++) {
		    System.out.printf("%d ", L[input.charAt(i) - 'A'] * L[input.charAt(i) - 'A']);
		  }

	}
	
	public static void TestIsPrimer() {
		MathHelper mathHelper = new MathHelper();
		int counter = 0;
		int[] L = new int[26];
		for(int i=10000;i>=2 && counter < 26;i--) {
			if(mathHelper.isPrime(i)) {
				
				L[counter++]=i;
			}
		}
		
		Arrays.sort(L);
		for(int i=0;i<26;i++) {
			System.out.printf("%d ", L[i]);
		}
		System.out.println();
		// System.out.println(mathHelper.isPrime(103));
	}
	
	public static void TestMathAdd() {
		MathHelper mathHelper = new MathHelper();
		System.out.println(mathHelper.add("123456789", "123456789"));
		
		System.out.println(mathHelper.add("123456789", "123456999999999"));
	}

}
