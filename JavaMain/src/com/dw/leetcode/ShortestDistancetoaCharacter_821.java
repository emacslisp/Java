package com.dw.leetcode;
import java.util.*;

public class ShortestDistancetoaCharacter_821 {

	public int[] shortestToChar(String S, char C) {
		int[] result = new int[S.length()];
		List<Integer> l = new ArrayList<Integer>();
		for(int i=0;i<S.length();i++) {
			if(C == S.charAt(i)) {
				l.add(i);
			}
		}
		
		for(int i=0;i<S.length();i++) {
			
			int offset = S.length();
			
			for(int x : l) {
				if (offset > Math.abs(x-i)) {
					offset = Math.abs(x-i);
				}
			}
			result[i] = offset;
		}
		return result;
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestDistancetoaCharacter_821 s = new ShortestDistancetoaCharacter_821();
		String S = "loveleetcode";
		char C = 'e';
		
		int[] result = s.shortestToChar(S, C);
		for(int x: result) {
			System.out.println(x);
		}
	}

}
