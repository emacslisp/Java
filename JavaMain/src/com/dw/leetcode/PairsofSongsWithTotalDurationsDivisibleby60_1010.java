package com.dw.leetcode;

public class PairsofSongsWithTotalDurationsDivisibleby60_1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] x = new int[60];
        
        for(int i=0;i<60;i++) x[i] = 0;
        
        for(int i=0;i<time.length;i++) {
        	x[time[i]%60]++;
        }
        int counter = x[0]*(x[0] - 1)/2 + x[30]*(x[30]-1)/2;
        
        for(int i=1;i<30;i++) {
        		counter += x[i]* x[60-i];
        }
        
        return counter;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PairsofSongsWithTotalDurationsDivisibleby60_1010 a = new PairsofSongsWithTotalDurationsDivisibleby60_1010();
		int[] time = {15,63,451,213,37,209,343,319};
		int result = a.numPairsDivisibleBy60(time);
		System.out.println(result);
	}
}
