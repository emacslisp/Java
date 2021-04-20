package com.dw.leetcode;

public class GuessNumberHigherorLower_374 {
	int pick = 1702766719;
	int guess(int num) {
		if(num > pick) return -1;
		
		if(num == pick) return 0;
		return 1;
	}
	
    public int guessNumber(int n) {
        long start = 1;
        long end = n;
        
        while(start <= end) {
        	long mid = (start + end)/2;
        	int r = guess((int)mid);
        	if(r == -1) {
        		end = mid - 1;
        	} else if(r == 1) {
        		start = mid + 1;
        	} else if(r == 0) {
        		return (int)mid;
        	}
        }
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessNumberHigherorLower_374 o = new GuessNumberHigherorLower_374();
		System.out.println(o.guessNumber(2126753390));
	}

}
