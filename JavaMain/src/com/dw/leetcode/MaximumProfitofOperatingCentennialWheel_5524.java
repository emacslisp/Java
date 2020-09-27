package com.dw.leetcode;

// https://leetcode.com/contest/weekly-contest-208/problems/maximum-profit-of-operating-a-centennial-wheel/
public class MaximumProfitofOperatingCentennialWheel_5524 {
	public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int cleft = 0;
        int cjoin = 0;
        int counter = 0;
        int profile = -1;
        int shift = 0;
        int maxCounter = 0;
        while(true) {
        	
        	if(counter >= customers.length && cleft == 0) {
        		break;
        	}
        	
        	if (counter < customers.length) {
        		cleft += customers[counter];
        	}
        	
        	if (cleft < 4) {
        		shift ++;
        		cjoin += cleft;
        		cleft = 0;
        	} else {
        		cleft -= 4;
        		shift++;
        		cjoin +=4;
        	}
        	
        	int t = cjoin * boardingCost - shift * runningCost;

        	if(t > profile) {
        		profile = t;
        		maxCounter = counter;
        	}
        	counter++;
        }
        
        if(profile == -1) return -1;
        
        return maxCounter + 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumProfitofOperatingCentennialWheel_5524 s = new MaximumProfitofOperatingCentennialWheel_5524();
		int[] customers = {3,4,0,5,1};
		int boardingCost = 1;
		int runningCost = 92;
		int result = s.minOperationsMaxProfit(customers, boardingCost, runningCost);
		System.out.println(result);
	}

}
