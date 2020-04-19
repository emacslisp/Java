package com.dw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DisplayTableFoodOrdersRestaurant_5389 {
    public List<List<String>> displayTable(List<List<String>> orders) {

        HashMap<Integer, HashMap<String, Integer>> map = new HashMap<Integer, HashMap<String, Integer>>();
        List<String> foodNameList = new ArrayList<String>();
        List<Integer> tableIdList = new ArrayList<Integer>();
        
        for(List<String> o : orders) {
        	String userName = o.get(0);
        	Integer tableId = Integer.parseInt(o.get(1));
        	String foodName = o.get(2);
        	
        	if(!foodNameList.contains(foodName)) {
        		foodNameList.add(foodName);
        	}
        	
        	if(!tableIdList.contains(tableId)) {
        		tableIdList.add(tableId);
        	}
        	
        	if(map.get(tableId) == null) {
        		map.put(tableId, new HashMap<String, Integer>());
        	}
        	
        	HashMap<String, Integer> x = map.get(tableId);
        	if(x.get(foodName) == null) {
        		x.put(foodName, 0);
        	}
        	
        	x.put(foodName, x.get(foodName)+1);
        }
        
        Collections.sort(foodNameList);
        Collections.sort(tableIdList);
        
        List<List<String>> result = new ArrayList<List<String>>();
        
        List<String> header = new ArrayList<String>();
        header.add("Table");
        
        for(String s: foodNameList) {
        	header.add(s);
        }
        
        result.add(header);
        
        for(Integer t: tableIdList) {
        	List<String> t1 = new ArrayList<String>();
        	
        	t1.add(t+"");
        	HashMap<String, Integer> x = map.get(t);
        	
        	for(String s: foodNameList) {
        		if(x.get(s) == null) {
        			t1.add("0");
        		}
        		else
        			t1.add(x.get(s) + "");
        	}
        	
        	result.add(t1);
        }
        
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] a = {{"David","3","Ceviche"},{"Corina","10","Beef Burrito"},{"David","3","Fried Chicken"},{"Carla","5","Water"},{"Carla","5","Ceviche"},{"Rous","3","Ceviche"}};
		List<List<String>> orders = new ArrayList<List<String>>();
		
		for(int i=0;i<a.length;i++) {
			List<String> row = new ArrayList<String>();
			for(int j=0;j<a[0].length;j++) {
				row.add(a[i][j]);
			}
			orders.add(row);
		}
		
		
		DisplayTableFoodOrdersRestaurant_5389 s = new DisplayTableFoodOrdersRestaurant_5389();
		
		List<List<String>> result = s.displayTable(orders);
		for(List<String> r: result) {
			for(String st: r) {
				System.out.print(st + "\t");
			}
			System.out.println();
		}
	}

}
