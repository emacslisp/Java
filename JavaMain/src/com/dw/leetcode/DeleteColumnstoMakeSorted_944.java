package com.dw.leetcode;

public class DeleteColumnstoMakeSorted_944 {
	public int minDeletionSize(String[] A) {
		int del = 0;
        for(int i=0;i<A[0].length();i++) {
        	char a = 'a';
        	for(int j= 0;j<A.length;j++) {
        		if(A[j].charAt(i) >= a) {
        			a = A[j].charAt(i);
        		} else {
        			del++;
        			break;
        		}
        	}
        }
        return del;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] A = {"zyx","wvu","tsr"};
		DeleteColumnstoMakeSorted_944 s = new DeleteColumnstoMakeSorted_944();
		System.out.println(s.minDeletionSize(A));
	}

}
