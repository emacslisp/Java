package com.dw.leetcode;

import static org.hamcrest.CoreMatchers.instanceOf;

public class JewelsandStones_771 {
	
	public static int numJewelsInStones(String J, String S) {
        int b1 = 0;
 int b2 = 0;
 
	for (int i = 0; i < J.length(); i++) {
		char a = J.charAt(i);

		if (a >= 'a' && a <= 'z')
			b1 |= 1 << (a - 'a');

		if (a >= 'A' && a <= 'Z')
			b2 |= 1 << (a - 'A');
	}
	int counter = 0;
	for(int i=0;i<S.length();i++) {
		char a = S.charAt(i);
		if (a >= 'a' && a <= 'z')
			if((b1&1<<(a-'a'))>>(a-'a') == 1) {
				counter ++;
			}

		if (a >= 'A' && a <= 'Z')
			if((b2&1<<(a-'A'))>>(a-'A') == 1) {
				counter ++;
			}
	}
 return counter;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String J = "ebd";
		String S = "bbb";
		
		System.out.println(numJewelsInStones(J,S));
	}

}
