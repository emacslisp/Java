package com.dw.leetcode;

public class CoinChange_322 {
	
	public int coinChange(int[] coins, int amount) {
		int result = 0;
		
		int[] dp = new int[amount+1];
		
		for(int i=0;i<dp.length;i++) {
			dp[i] = -1;
		}
		
		dp[0] = 0;
		
		for(int i=1;i<=amount;i++) {
			for(int j=0;j<coins.length;j++) {
				if(coins[j]<=i && dp[i-coins[j]] != -1) {
					dp[i] = (dp[i] == -1? 1+dp[i-coins[j]]: Math.min(dp[i], 1+dp[i-coins[j]]));
				}
			}
		}
		
		return dp[amount];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,2,5};
		
		CoinChange_322 s = new CoinChange_322();
		
		System.out.println(s.coinChange(coins, 11));;
		
	}

}
