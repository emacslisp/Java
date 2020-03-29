package com.dw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class DesignUndergroundSystem_5370 {
	class pair {
		public String stationName;
		public int time;
		public pair(String stationName, int time) {
			this.stationName = stationName;
			this.time = time;
		}
	}
	HashMap<Integer, pair> inMap;
	HashMap<String, ArrayList<Integer>> map;
	
    public DesignUndergroundSystem_5370() {
    	inMap = new HashMap<Integer, pair>();
    	map = new HashMap<String, ArrayList<Integer>>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        inMap.put(id, new pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        if(inMap.get(id) != null) {
        	String outKey = inMap.get(id).stationName + stationName;
        	int outTime = t - inMap.get(id).time;
        	if(map.get(outKey) == null) {
        		map.put(outKey, new ArrayList<Integer>());
        	}
        	
        	map.get(outKey).add(outTime);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String outKey = startStation + endStation;
        
        ArrayList<Integer> list = map.get(outKey);
        
        double result = 0;
        
        for(int l : list) {
        	result += l;
        }
        
        return (double) result / (double) list.size();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesignUndergroundSystem_5370 undergroundSystem = new DesignUndergroundSystem_5370();
		
		undergroundSystem.checkIn(45, "Leyton", 3);
		undergroundSystem.checkIn(32, "Paradise", 8);
		undergroundSystem.checkIn(27, "Leyton", 10);
		
		undergroundSystem.checkOut(45, "Waterloo", 15);
		undergroundSystem.checkOut(27, "Waterloo", 20);
		undergroundSystem.checkOut(32, "Cambridge", 22);
		
		System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
		undergroundSystem.checkIn(10, "Leyton", 24);
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
		
		undergroundSystem.checkOut(10, "Waterloo", 38);
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
	}

}
