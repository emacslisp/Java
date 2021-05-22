package com.dw.leetcode;

public class SortingtheSentence_1859 {

    public String sortSentence(String s) {
        String[] a = s.split(" ");
        String[] r = new String[a.length];
        StringBuilder sbString = new StringBuilder();
        StringBuilder numberString = new StringBuilder();
        for(String x : a) {
        	sbString.setLength(0);
    		numberString.setLength(0);
    		
        	for(char c : x.toCharArray()) {
        		if((c -'a' >= 0 && c-'z' <= 0)||
        				(c-'A'>=0 && c-'Z' <= 0)) {
        			sbString.append(c);
        		} else if(c - '0' >= 0 && c-'9'<=0) {
        			numberString.append(c);
        		}
        	}
        	
        	int index = Integer.parseInt(numberString.toString());
    		r[index - 1] = sbString.toString();
        }
        
        sbString.setLength(0);
        numberString.setLength(0);
        
        for(String x: r) {
        	sbString.append(x).append(" ");
        }
        
        return sbString.toString().substring(0, sbString.length()-1);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortingtheSentence_1859 s = new SortingtheSentence_1859();
		String str = "is2 sentence4 This1 a3";
		String result = s.sortSentence(str);
		
		System.out.println(result);
	}

}
