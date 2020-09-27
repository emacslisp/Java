package com.dw.leetcode;

// https://leetcode.com/contest/weekly-contest-208/problems/crawler-log-folder/
public class CrawlerLogFolder_5523 {
	public int minOperations(String[] logs) {
        int counter = 0;
        
        for(String log : logs) {
        	String[] ls = log.split("/");
        	if (ls[0].equals("..")) {
        		counter --;
        		if(counter < 0) counter = 0;
        		continue;
        	}
        	
        	if(ls[0].equals(".")) {
        		continue;
        	}
        	
        	counter++;
        }
        
        return counter;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] logs = {"d1/","d2/","../","d21/","./"};
		CrawlerLogFolder_5523 s = new CrawlerLogFolder_5523();
		
		int result = s.minOperations(logs);
		System.out.println(result);
	}

}
