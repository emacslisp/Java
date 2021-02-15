package com.dw.leetcode;

public class FindKthBitinNthBinaryString_1545 {

	public String invest(String s) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == '0') {
				sb.append('1');
			} else {
				sb.append('0');
			}
		}
		return sb.toString();
	}
	public String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		return sb.reverse().toString();
	}
	public char findKthBit(int n, int k) {
		String s = "0";
		
		int counter = 0;
		while(counter < n) {
			s = s + "1" + reverse(invest(s));
			counter++;
		}
		return s.charAt(k - 1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindKthBitinNthBinaryString_1545 s= new FindKthBitinNthBinaryString_1545();
		char c = s.findKthBit(20, (int)(Math.pow(2, 20) - 1));
		System.out.println(c);
		
	}

}
