package com.dw.leetcode;

import java.util.*;

public class NumberofEquivalentDominoPairs_1128 {
	public class Pair {
		public int first;
		public int second;
		
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
		
		@Override
		public int hashCode() {
		    return (new Integer(first)).hashCode() + 31*(new Integer(second)).hashCode();
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
	        if (!(o instanceof Pair)) return false;
	        Pair o1 = (Pair)o;
		   return (this.first == o1.first && this.second == o1.second) || (this.first == o1.second && this.second == o1.first);
		}
	}
	public int numEquivDominoPairs(int[][] dominoes) {
		HashMap<Pair, Integer> map = new HashMap<>();
		
		for(int i=0;i<dominoes.length;i++) {
			Pair p1 = new Pair(dominoes[i][0], dominoes[i][1]);
			Pair p2 = new Pair(dominoes[i][1], dominoes[i][0]);
			
			if(map.containsKey(p1)) {
				map.put(p1, map.get(p1)+1);
			} else if(map.containsKey(p2)) {
				map.put(p2, map.get(p2)+1);
			} else {
				map.put(p1, 1);
			}
		}
		
		int result = 0;
		
		for(Pair p : map.keySet()) {
			int t1 = map.get(p);
			result += t1*(t1-1)/2;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofEquivalentDominoPairs_1128 n = new NumberofEquivalentDominoPairs_1128();
		int[][] a = {{1,2},{2,1},{1, 2}, {3,4},{5,6}};
		int result = n.numEquivDominoPairs(a);
		System.out.println(result);
	}

}
