package com.dw.leetcode;

import java.util.*;

public class PowerfulIntegers_970 {

	public List<Integer> powerfulIntegers(int x, int y, int bound) {
		List<Integer> result = new ArrayList<Integer>();
		
		int x1 = x==1? x: (int) (Math.log10(bound)/Math.log10(x));
		int y1 = y==1? y: (int) (Math.log10(bound)/Math.log10(y));
		
		
		for (int i=0;i<=x1;i++) {
			for (int j=0;j<=y1;j++) {
				int num = (int)( Math.pow(x, i) + Math.pow(y, j));
				if(!result.contains(num) && num <= bound) {
					result.add(num);
				}
			}
		}

		Collections.sort(result);
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerfulIntegers_970 s= new PowerfulIntegers_970();
		int x = 2;
		int y = 1;
		int bound = 10;
		List<Integer> result = s.powerfulIntegers(x, y, bound);
		for (int x1 : result) {
			System.out.println(x1);
		}
	}

}
