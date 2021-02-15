package com.dw.leetcode;

import java.util.*;

public class PrintWordsVertically_1324 {
	public List<String> printVertically(String s) {
		List<String> result = new ArrayList<String>();
		
		String[] a = s.split(" ");
		
		int x = 0;

		for(String str: a) {
			if(x < str.length()) {
				x = str.length();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<x;i++) {
			sb.setLength(0);
			
			for(String str: a) {
				if(i < str.length()) {
					sb.append(str.charAt(i));
				} else {
					sb.append(' ');
				}
			}
			
			String re = sb.toString();
			
			if (re.endsWith(" ")) {
				int index = 0;
				for(int k =re.length() - 1;k>=0;k--) {
					if(re.charAt(k) != ' ') {
						index = k;
						break;
					}
				}
				
				re = re.substring(0, index + 1);
			}
			
			result.add(re);
		}
		
		
		
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintWordsVertically_1324 s = new PrintWordsVertically_1324();
		String str = "CONTEST IS COMING";
		List<String> result = s.printVertically(str);
		
		for(String x: result) {
			System.out.println(x);
		}
	}

}
