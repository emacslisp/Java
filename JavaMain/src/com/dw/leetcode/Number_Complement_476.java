package com.dw.leetcode;

//@example: Leetcode - 476. Number Complement - https://leetcode.com/problems/number-complement/#/description
public class Number_Complement_476 {

	public static int findComplement(int num) {
        
        int t = num;
        int counter = 0;
        while(t!=0) {
            counter++;
            t=t>>1;
        }

        int mask = 0;
        for(int i=0;i<counter;i++) {
            mask+=(1<<i);
        }

        return mask &(~num);
    }
	
	public static void main(String[] args) {
		
		System.out.println(findComplement(1));
	}

}
