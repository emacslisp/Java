package com.dw.leetcode;

import java.util.*;

// https://leetcode.com/contest/weekly-contest-189/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/
public class PeopleFavoriteCompanies_5414 {

	public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
		List<Integer> result = new ArrayList<Integer>();
		HashMap<Integer, HashMap<String, Integer>> map = new HashMap<Integer, HashMap<String, Integer>>();
		
		int counter = 0;
		for(List<String> s: favoriteCompanies ) {
			if(map.get(counter) == null) {
				map.put(counter, new HashMap<String, Integer>());
			}
			
			HashMap<String, Integer> tmap = map.get(counter);
			
			for(String x : s) {
				tmap.put(x, 1);
			}
			
			counter++;
		}
		
		for(int i=0;i<favoriteCompanies.size();i++) {
			boolean isSubSet = false;
			for(int j=0;j<favoriteCompanies.size();j++) {
				if(i==j) continue;
				
				HashMap<String, Integer> tmap = map.get(j);
				boolean contains = true;
				for(String m : favoriteCompanies.get(i)) {
					if(tmap.get(m) == null) {
						contains = false;
						break;
					}
				}
				
				if(contains) {
					isSubSet = true;
					break;
				}
			}
			
			if(!isSubSet)
				result.add(i);
		}
		
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] a = {{"leetcode","google","facebook"},{"leetcode","amazon"},{"facebook","google"}};
		
		List<List<String>> favoriteCompanies = new ArrayList<List<String>>();
		
		for(int i=0;i<a.length;i++) {
			List<String> tList = new ArrayList<String>();
			for(int j=0;j<a[i].length;j++) {
				tList.add(a[i][j]);
			}
			favoriteCompanies.add(tList);
		}
		
		PeopleFavoriteCompanies_5414 s = new PeopleFavoriteCompanies_5414();
		
		List<Integer> result = s.peopleIndexes(favoriteCompanies);
		
		for(Integer x : result) {
			System.out.println(x);
		}
	}

}
