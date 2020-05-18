package com.dw.leetcode;

public class MaximumNumberofDarts_5415 {
    public int numPoints(int[][] points, int r) {
       
        int xMax = Integer.MIN_VALUE;
        int xMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        
        for(int i=0;i<points.length;i++) {
        	if(xMax < points[i][0]) {
        		xMax = points[i][0];
        	}
        	
        	if(xMin > points[i][0]) {
        		xMin = points[i][0];
        	}
        	
        	if(yMax < points[i][1]) {
        		yMax = points[i][1];
        	}
        	
        	if(yMin > points[i][1]) {
        		yMin = points[i][1];
        	}
        }
        
        int tx = (xMax+xMin)/2;
        int yx = (yMax + yMin)/2;
        int maxCounter = 0;
        for(int i=xMin;i<=xMax;i++) {
        	int counter = 0;
        	 for(int j=0;j<points.length;j++) {
        		 if( (points[j][0] - i) * (points[j][0] - i) + (points[j][1] - yx)* (points[j][1] - yx) <= r*r) {
        			 counter++;
        		 }
        	 }
        	 
        	 if(counter > maxCounter) {
        		 maxCounter = counter;
        	 }
        	 
        	 counter = 0;
        	 for(int j=0;j<points.length;j++) {
        		 if( (points[j][0] - i) * (points[j][0] - i) + (points[j][1] - yx - 1)* (points[j][1] - yx - 1) <= r*r) {
        			 counter++;
        		 }
        	 }
        	 if(counter > maxCounter) {
        		 maxCounter = counter;
        	 }
        	 
        	 counter = 0;
        	 for(int j=0;j<points.length;j++) {
        		 if( (points[j][0] - i) * (points[j][0] - i) + (points[j][1] - yx + 1)* (points[j][1] - yx + 1) <= r*r) {
        			 counter++;
        		 }
        	 }
        	 
        	 if(counter > maxCounter) {
        		 maxCounter = counter;
        	 }
        }
        
        for(int i=yMin;i<=yMax;i++) {
        	int counter = 0;
        	 for(int j=0;j<points.length;j++) {
        		 if( (points[j][0] - tx) * (points[j][0] - tx) + (points[j][1] - i)* (points[j][1] - i) <= r*r) {
        			 counter++;
        		 }
        	 }
        	 
        	 if(counter > maxCounter) {
        		 maxCounter = counter;
        	 }
        	 
        	 counter = 0;
        	 for(int j=0;j<points.length;j++) {
        		 if( (points[j][0] - tx + 1) * (points[j][0] - tx + 1) + (points[j][1] - i)* (points[j][1] - i) <= r*r) {
        			 counter++;
        		 }
        	 }
        	 
        	 if(counter > maxCounter) {
        		 maxCounter = counter;
        	 }
        	 
        	 counter = 0;
        	 for(int j=0;j<points.length;j++) {
        		 if( (points[j][0] - tx - 1) * (points[j][0] - tx - 1) + (points[j][1] - i)* (points[j][1] - i) <= r*r) {
        			 counter++;
        		 }
        	 }
        	 
        	 if(counter > maxCounter) {
        		 maxCounter = counter;
        	 }
        }
        
        return maxCounter;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println( (int)(0 - 3)/2);
	}

}
