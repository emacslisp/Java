package com.dw.leetcode;

import java.util.*;

public class DestinationCity_5400 {
    public String destCity(List<List<String>> paths) {
        String target = "";
        
        HashMap<String, String> map = new HashMap<String, String>();
        
        for (List<String> path : paths) {
        	String pathA = path.get(0);
        	String pathB = path.get(1);
        	map.put(pathA, pathB);
        }
        
        String start = paths.get(0).get(0);
        
        while(true) {
        	if(map.get(start) == null) {
        		target = start;
        		break;
        	} else {
        		start = map.get(start);
        	}
        }
        
        return target;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] paths = {{"A","Z"}}; 
				//{{"London","New York"},{"New York","Lima"},{"Lima","Sao Paulo"}};
		
		List<List<String>> pathList = new ArrayList<List<String>>();
		
		for(int i=0;i<paths.length;i++) {
			List<String> path = new ArrayList<String>();
			for(int j=0;j<paths[0].length;j++) {
				path.add(paths[i][j]);
			}
			pathList.add(path);
		}
		
		DestinationCity_5400 s = new DestinationCity_5400();
		
		System.out.println(s.destCity(pathList));
	}

}
