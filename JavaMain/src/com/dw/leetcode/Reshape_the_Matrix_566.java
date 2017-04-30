package com.dw.leetcode;

//@example: Leetcode - 566. Reshape the Matrix - https://leetcode.com/problems/reshape-the-matrix/#/description
public class Reshape_the_Matrix_566 {
	
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length == 0) return nums;
		if(nums.length * nums[0].length != r*c) return nums;
		
		int[] array = new int[r*c];
		
		int[][] result = new int[r][c];
		
		for(int i=0;i<nums.length;i++)
			for(int j=0;j<nums[0].length;j++ ){
				array[i*nums[0].length + j] = nums[i][j];
			}
		
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++ ){
				result[i][j] = array[i*c+j];
			}
		
		return result;
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = new int[2][2];
		test[0][0]=1;
		test[0][1]=2;
		test[1][0]=3;
		test[1][1]=4;
		
		int[][] result = matrixReshape(test,4,1);
		
		for(int i=0;i<4;i++) { 
			for(int j=0;j<1;j++ ){
				System.out.print(result[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}

}
