package com.dw.leetcode;

public class RectangleArea_223 {
	
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
    	long areaA = Math.abs((C-A)*(D-B));
    	
    	long areaB = Math.abs((G-E)*(H-F));
    	
    	long overlapArea = 0;
    	long overlapX  = 0;
    	long overlapY = 0;
    	
    	if(Math.min(C, G) > Math.max(A, E))
    		overlapX = Math.min(C, G) - Math.max(A, E);
    	
    	if(Math.min(D, H) > Math.max(B, F))
    		overlapY = Math.min(D, H) - Math.max(B, F);
    	
    	if(overlapX >0 && overlapY>0) {
    		overlapArea = overlapX * overlapY;
    	}
    	
    	return (int)(areaA + areaB - overlapArea);
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RectangleArea_223 s = new RectangleArea_223();
		
		System.out.println(s.computeArea(-1500000001,0,-1500000000,1,1500000000,0,1500000001,1));
	}

}
