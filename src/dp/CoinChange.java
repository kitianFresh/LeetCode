package dp;

import java.util.Arrays;

public class CoinChange {
	
	// 法一　dp top down; use a cache to store all computed result
	// F(A) = min {F(A-Ci) + 1} i = 0,1,2,..n
	public int coinChange(int[] coins, int amount) {        
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }
	
    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
    
    
    // 法二　dp. bottom up dp[a] 表示当前面额时候最小的零钱个数，则　dp[a] = min{dp[a-coins[j]]+1, dp[a]}, j= 0,1,2,..n
    public int coinChange1(int[] coins, int amount) {        
        if (amount < 1) return 0;
        if (coins == null || coins.length == 0) return -1;
        int len = coins.length;
        int[] dp = new int[amount+1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int a = 1; a <= amount; a ++) {
            for (int j = 0; j < coins.length; j ++) {
                if (coins[j] <= a) {
                    dp[a] = Math.min(dp[a], dp[a-coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
