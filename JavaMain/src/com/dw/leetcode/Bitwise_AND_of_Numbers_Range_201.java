package com.dw.leetcode;

public class Bitwise_AND_of_Numbers_Range_201 {
	public static int rangeBitwiseAnd(int m, int n) {
		if(m == 0){
            return 0;
        }
		
        int counter = 0;
		while(m!=n) {
			m>>=1;
			n>>=1;
			counter++;
		}
		
		return m*(1<<counter);
		
    }

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		System.out.println(rangeBitwiseAnd(5,7));
		
	}
}
