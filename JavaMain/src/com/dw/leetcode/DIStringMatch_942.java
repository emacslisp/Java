package com.dw.leetcode;

public class DIStringMatch_942 {
    public int[] diStringMatch(String S) {
        int N = S.length();
        
        int IIndex = 0;
        int DIndex = N;
        
        int[] result = new int[N+1];
        
        for(int i=0;i<N;i++) {
        	if (S.charAt(i) == 'I') {
        		result[i] = IIndex++;
        	}
        	
        	if (S.charAt(i) == 'D') {
        		result[i] = DIndex--;
        	}
        }
        result[N] = IIndex;
        
        return result;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DIStringMatch_942 s= new DIStringMatch_942();
		
		int[] result = s.diStringMatch("III");
		
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i] + "\t");
		}
		System.out.println();
	}

}
