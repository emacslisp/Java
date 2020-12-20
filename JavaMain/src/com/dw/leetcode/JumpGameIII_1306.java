package com.dw.leetcode;

public class JumpGameIII_1306 {

    public boolean canReach(int[] arr, int start) {
    	if ((start < 0 || start >= arr.length) || (arr[start] == -1)) return false;
        if(arr[start] == 0) return true;
        
        boolean result = false;
        int orig = arr[start];
        
        arr[start] = -1;
        
        if(start + orig < arr.length) {
        	result |= canReach(arr, start + orig );
        }
        
        if(start - orig >=0) {
        	result |= canReach(arr, start - orig);
        }
        
        arr[start] = orig;
        
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {3,0,2,1,2};
		int start = 2;
		JumpGameIII_1306 s = new JumpGameIII_1306();
		boolean result = s.canReach(arr, start);
		System.out.println(result);
	}

}
