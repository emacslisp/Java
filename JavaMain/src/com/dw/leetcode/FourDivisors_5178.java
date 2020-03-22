package com.dw.leetcode;

public class FourDivisors_5178 {
	public int sumFourDivisors(int[] nums) {
        int result = 0;
		for(int i=0;i<nums.length;i++) {
			int counter=0;
			for(int j=2;j<=Math.sqrt(nums[i]);j++) {
				if(nums[i]%j == 0) {
					counter++;
					
					if(j < nums[i]/j) {
						counter++;
					}
				}
			}
					
			if(counter == 2) {
				for(int j=2;j<=Math.sqrt(nums[i]);j++) {
					if(nums[i]%j == 0) {
						result += j;
						
						if(j < nums[i]/j) {
							result += nums[i]/j;
						}
					}
				}
				result += (1+nums[i]);
			}
		}
		
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourDivisors_5178 s = new FourDivisors_5178();
		int nums[] = {21,4,7};
		int result = s.sumFourDivisors(nums);
		System.out.println(result);
	}

}
