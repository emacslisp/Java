package com.dw.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.dw.leetcode.Rank_Teams_by_Votes_5345.pair;

public class Rank_Teams_by_Votes_5345 {

	class pair {
		char letter;
		int counter;
	}
    public String rankTeams(String[] votes) {
    	if (votes.length == 1) return votes[0];
    	
    	List<ArrayList<pair>> mainList = new ArrayList<ArrayList<pair>>();
    	
    	int[] letterIndex = new int[26];
    	
    	for (int i=0;i<votes[0].length();i++) {
    		
    		for(int j=0;j<votes.length;j++) {
    			
    		}
    	}
    	
    	return "";
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
