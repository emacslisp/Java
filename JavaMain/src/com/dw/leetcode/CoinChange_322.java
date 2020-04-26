package com.dw.leetcode;

public class CoinChange_322 {
	
	public void printOutDP(int[] dp) {
		for(int i=0;i<dp.length;i++) {
			System.out.print(dp[i] + "\t");
		}
		System.out.println();
	}
	
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
					System.out.println("i:" + i + " j:" + j + " coins[j]:" + coins[j] + " i-coins[j]:" + (i-coins[j]));
					System.out.println("dp[i]:" + dp[i] + " dp[i-coins[j]]:" + dp[i-coins[j]]);
					dp[i] = (dp[i] == -1? 1+dp[i-coins[j]]: Math.min(dp[i], 1+dp[i-coins[j]]));
					printOutDP(dp);
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
