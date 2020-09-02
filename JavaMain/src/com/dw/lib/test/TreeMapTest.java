package com.dw.lib.test;

import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>();
	    map.put(3, "val");
	    map.put(2, "val");
	    map.put(1, "val");
	    map.put(5, "val");
	    map.put(4, "val");
	    
	    System.out.println(map.keySet().toString());
	}
}
