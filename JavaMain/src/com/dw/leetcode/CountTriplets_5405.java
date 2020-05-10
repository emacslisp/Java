package com.dw.leetcode;

///https://leetcode.com/contest/weekly-contest-188/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
public class CountTriplets_5405 {

    public int countTriplets(int[] arr) {
    	int counter=0;
        for(int i=0;i<arr.length;i++) {
        	for(int j=i+1;j<arr.length;j++) {
        		for(int k=j;k<arr.length;k++) {
        			int a = 0;
        			int b = 0;
        			for(int m = i;m<=j-1;m++) {
        				a ^= arr[m];
        			}
        			
        			for(int n=j;n<=k;n++) {
        				b ^= arr[n];
        			}
        			
        			if(a == b) {
        				counter ++;
        				
        				System.out.println(i + " " + j + " " + k);
        			}
        		}
        	}
        }
        return counter;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountTriplets_5405 s = new CountTriplets_5405();
		int[] arr = {7,11,12,9,5,2,7,17,22};
		System.out.println(s.countTriplets(arr));
	}

}
