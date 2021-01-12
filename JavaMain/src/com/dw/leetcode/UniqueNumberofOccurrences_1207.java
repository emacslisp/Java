package com.dw.leetcode;
import java.util.*;
public class UniqueNumberofOccurrences_1207 {
	public boolean uniqueOccurrences(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		HashMap<Integer, Integer> check = new HashMap<>();
		
        for(int i=0;i<arr.length;i++) {
        	if(map.containsKey(arr[i])) {
        		map.put(arr[i], map.get(arr[i]) + 1);
        	} else {
        		map.put(arr[i], 1);
        	}
        }
        
        for(int x : map.keySet()) {
        	if(check.containsKey(map.get(x))) {
        		return false;
        	} else {
        		check.put(map.get(x), 1);
        	}
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2};
		UniqueNumberofOccurrences_1207 s = new UniqueNumberofOccurrences_1207();
		boolean result = s.uniqueOccurrences(arr);
		System.out.println(result);
	}

}
