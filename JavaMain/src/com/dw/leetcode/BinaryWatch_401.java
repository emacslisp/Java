package com.dw.leetcode;

import java.util.*;

public class BinaryWatch_401 {
	
	public List<String> readBinaryWatch(int num) {
		List<String> result = new ArrayList<String>();
		
		for(int h=0;h<12;h++) {
			for(int m=0;m<60;m++) {
				if ( (Integer.bitCount(h) + Integer.bitCount(m)) == num) {
					result.add(h+":"+ (m>=10? ""+m: "0"+m));
				}
			}
		}
		
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryWatch_401 s= new BinaryWatch_401();
		List<String> result = s.readBinaryWatch(2);
		
		for(String x : result) {
			System.out.println(x);
		}
	}

}
