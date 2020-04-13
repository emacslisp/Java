package com.dw.leetcode;

public class QueriesPermutationWithKey {
    public int[] processQueries(int[] queries, int m) {
    	
    	int[] result = new int[queries.length];
    	
    	int[] P = new int[m];
    	
    	for(int i=1;i<=P.length;i++) {
    		P[i-1] = i;
    	}
    	
    	int counter = 0;
    	for(int q: queries) {
    		for(int i=0;i<m;i++) {
    			if(P[i]==q) {
    				result[counter++] = i;
    				for(int n=i;n>0;n--) {
    					P[n] = P[n-1];
    				}
    				P[0] = q;
    			}
    		}
    	}
    	
    	return result;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] queries = {7,5,5,8,3};
		int m = 8;
		
		QueriesPermutationWithKey s = new QueriesPermutationWithKey();
		int[] result = s.processQueries(queries, m);
		
		for(int w: result) {
			System.out.println(w);
		}
	}

}
