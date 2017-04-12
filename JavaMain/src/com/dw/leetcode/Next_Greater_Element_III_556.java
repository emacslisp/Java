package com.dw.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//@example: Leetcode - 556. Next Greater Element III - https://leetcode.com/problems/next-greater-element-iii/#/description
public class Next_Greater_Element_III_556 {

	public static char[] reverse(char[] s) {
		char[] array = s;

		for (int i = 0; i < array.length / 2; i++) {
			char temp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;
		}

		return array;

	}

	public static int nextGreaterElement(int n) {
		StringBuilder s = new StringBuilder();

		int p = n;

		while (p > 0) {
			s.append(p % 10);
			p = p / 10;
		}

		char[] y = reverse(s.toString().toCharArray());
		
		long result = -1;
		int i;
		for(i=y.length - 1;i>0;i--)
			if(y[i]> y[i-1])
				break;
		
		if(i==0)
			return -1;
		
		char x = y[i-1]; int smallest = i;
		
		for(int k=i+1;k<y.length;k++)
			if(y[k] > x && y[k] <= y[smallest])
				smallest = k;
		
		char temp = y[i-1];
		y[i-1] = y[smallest];
		y[smallest] = temp;
		
		Arrays.sort(y,i,y.length);
		
		result = Long.parseLong(new String(y));
		
		if (result > Integer.MAX_VALUE)
			return -1;
		
		return (int) result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nextGreaterElement(1234));
	}

}
