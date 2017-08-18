package com.dw.leetcode;

/*
 * idea is easy
 * f[i] = f[i/2] + i%2;
 */
public class Counting_Bits_338 {

    public int[] countBits(int num) {
        int[] f = new int[num + 1];
	    for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
	    return f;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Counting_Bits_338 s= new Counting_Bits_338();
		int[] a = s.countBits(10);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i] + "\t");
		System.out.println("\n");
	}

}
