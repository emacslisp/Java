package com.dw.leetcode;

public class BulbSwitcherIII_5353 {
	
    public int numTimesAllBlue(int[] light) {
        int counter = 0;
        
        int[] isOn = new int[light.length];
        
        for (int i=0;i<light.length;i++) {
        	isOn[i] = 0;
        }
        
        int max = 0;
        
        for (int i=0;i<light.length;i++) {
        	
        	isOn[light[i] - 1] = 1;
        	
        	if (max < light[i]) {
        		max = light[i];
        	}
        	
        	if(light[i] > (i+1)) {
        		continue;
        	}
        	
        	boolean isBlue = true;
        	for (int j=max-1;j>=0;j--) {
        		if(isOn[j] == 0) {
        			isBlue = false;
        			break;
        		}
        	}
        	
        	if(isBlue)
        		counter++;
        }
        
        return counter;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BulbSwitcherIII_5353 s= new BulbSwitcherIII_5353();
		int[] light = {4,1,2,3};
		int counter = s.numTimesAllBlue(light);
		
		System.out.println(counter);
	}

}
