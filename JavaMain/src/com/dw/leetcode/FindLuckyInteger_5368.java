package com.dw.leetcode;

import java.util.HashMap;

public class FindLuckyInteger_5368 {
	public int findLucky(int[] arr) {
		int max = -1;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0;i<arr.length;i++) {
			if(map.get(arr[i]) == null) {
				map.put(arr[i], 1);
				continue;
			}
			
			map.put(arr[i],	map.get(arr[i]) + 1);
		}
		
		for (int key : map.keySet()) {
			if(key == map.get(key)) {
				max = key > max? key: max;
			}
		}
		
		return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindLuckyInteger_5368 s = new FindLuckyInteger_5368();
		int[] arr = {5};
		System.out.println(s.findLucky(arr));
	}

}
