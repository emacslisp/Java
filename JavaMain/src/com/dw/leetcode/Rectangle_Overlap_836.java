package com.dw.leetcode;

public class Rectangle_Overlap_836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean result = false;
        
        long rec1X = rec1[2] - rec1[0];
        long rec1Y = rec1[3] - rec1[1];
        
        long rec2X = rec2[2] - rec2[0];
        long rec2Y = rec2[3] - rec2[1];
        
        long rec3X = Math.max(rec1[2], rec2[2]) - Math.min(rec1[0], rec2[0]);
        long rec3Y = Math.max(rec1[3], rec2[3]) - Math.min(rec1[1], rec2[1]); 
        
        if(!(rec3X >= (rec1X + rec2X) || rec3Y >= (rec1Y + rec2Y)) ) {
        	result = true;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	
    	int rec1[] = {-257926405,-680763313,702840196,454409669};
    			 int rec2[] = {-275916328,-417802221,22808107,675629469};
    	Rectangle_Overlap_836 x = new Rectangle_Overlap_836();
    	System.out.println(x.isRectangleOverlap(rec1, rec2));
    	
    	
    }
}
