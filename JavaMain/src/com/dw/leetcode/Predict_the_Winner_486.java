package com.dw.leetcode;

public class Predict_the_Winner_486 {
	
	/*
	 * int[] choosed = new int[nums.size];
	 * int begin = 0;
	 * int end = nums.size-1;
	 * int counter = 0;
	 * int play1 = 0;
	 * int play2 = 0;
	 * bool finalResult = false;
	 * foo(play1,play2,begin,end,counter) {
	 *    
	 * 	  if(begin > end) { 
	 * 		 if(play1 > play2) finalResult = true;
	 *       return;
	 *    }
	 *    
	 *    //play 1 choose 1
	 *    choosed[begin] = 1;
	 *    int tempPlay1 = play1;
	 *    int tempPlay2 = play2;
	 *    if(counter %2 == 0)
	 *    	tempPlay1 = play1 + nums[begin];
	 *    
	 *    if(counter %2 == 1)
	 *    	tempPlay2 = play2 + nums[begin];
	 * 	  
	 *    foo(tempPlay1,tempPlay2, begin + 1,end, counter+1);
	 *    
	 *    tempPlay1 = play1;
	 *    tempPlay2 = play2;
	 *     //play 1 choose 2
	 *    choosed[end] = 1;
	 *    if(counter %2 == 0)
	 *    	tempPlay1 = play1 + nums[end];
	 *    
	 *    if(counter %2 == 1)
	 *    	tempPlay2 = play2 + nums[end];
	 *    foo(tempPlay1,tempPlay2,begin,end - 1, counter+1);
	 *    
	 * 
	 * }
	 */
	//@example: recursive bruce force.
	public static boolean foo(int play1,int play2, int begin,int end,int counter,int[] nums,int[] choosed) {
		if(begin > end) { 
		    if(play1 > play2) return true;
		    return false;
		}

		//play 1 choose 1
		choosed[begin] = 1;
		int tempPlay1 = play1;
		int tempPlay2 = play2;
		if(counter %2 == 0)
		    tempPlay1 = play1 + nums[begin];

		if(counter %2 == 1)
		    tempPlay2 = play2 + nums[begin];
		    
		boolean result = foo(tempPlay1,tempPlay2, begin + 1,end, counter+1,nums,choosed);
		
		if(result) return true;

		tempPlay1 = play1;
		tempPlay2 = play2;
		//play 1 choose 2
		choosed[end] = 1;
		if(counter %2 == 0)
		    tempPlay1 = play1 + nums[end];

		if(counter %2 == 1)
		    tempPlay2 = play2 + nums[end];
		result = foo(tempPlay1,tempPlay2,begin,end - 1, counter+1,nums,choosed);
		
		if(result) return true;
		
		return false;
	}
	
	public static boolean PredictTheWinner(int[] nums) {
		int[] choosed = new int[nums.length];
		
		return foo(0,0,0,nums.length-1,0,nums,choosed);
    }
	public static void main(String[] args) {
		int[] test = {1, 5, 2};
		
		System.out.println(PredictTheWinner(test));
	}

}
