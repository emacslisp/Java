package com.dw.leetcode;

public class Convert_to_Base_2 {

	public String baseNeg2(int N) {
		if (N == 0)
			return "0";
		
		StringBuilder result = new StringBuilder();

		int i = 0;

		int temp;
		
		while (N != 0) {

			temp = N % (-2);
			N = (N - Math.abs(temp))/(-2);

			if (temp == 1) {
				result.append('1');
			} else
				result.append(temp == 0 ? '0' : '1');

		}

		return result.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Convert_to_Base_2 s= new Convert_to_Base_2();
		System.out.println(s.baseNeg2(6));
	}

}
