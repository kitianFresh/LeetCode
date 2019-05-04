import java.util.ArrayList;
import java.util.List;

public class Coins {
	// 1. 有1分,2分,5分,10分四种硬币，每种硬币数量无限，给定n分钱，求有多少种组合可以组合成n分钱
	
	// 1. 方法一， dfs 回溯， 穷举所有组合
	// 1. 方法二，动态规划
	public static void backtrace(int[] coins, List<List<Integer>> res, List<Integer> path, int start, int left) {
		if (left < 0) {
			return;
		}
		if (left == 0) {
			res.add(new ArrayList<Integer>(path));
			return;
		}
		for (int i = start; i < coins.length; i ++) {
			path.add(coins[i]);
			backtrace(coins, res, path, i, left - coins[i]);
			path.remove(path.size()-1);
		}
	}
	
	public static void coinsComb(int n) {
		int[] coins = new int[]{1,2,5,10};
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		backtrace(coins, res, path, 0, n);
		for (List<Integer> e: res) {
			System.out.println(e);
		}
	}
	//1. 方法二，动态规划
	// dp[i][sum] 表示当前种类i种硬币凑成sum的总组合数，则
	// dp[i][sum] = dp[i-1][sum-0*vi] + dp[i-1][sum-1*vi] + d[i-1][sum-2*vi] +...+dp[i-1][sum-k*vi]; k = sum/vi;
	// dp[0][n] = 0(n!=0); dp[i][0] = 1;
	public static int coinsCombDP(int[] coins, int sum) {
		int coinKinds = coins.length;
		int[][] dp = new int[coinKinds+1][sum+1];
		for (int i = 0; i <= coinKinds; i ++) dp[i][0] = 1;
		for (int i = 1; i <= coinKinds; i ++) {
			for (int s = 1; s <= sum; s ++) {
				dp[i][s] = 0;
				for (int k = 0; k <=s/coins[i-1]; k ++) {
					dp[i][s] += dp[i-1][s-k*coins[i-1]];
				}
			}
		}
		return dp[coinKinds][sum];
	}
	
	// 2. 假设有 1 元，3 元，5 元的硬币若干（无限），现在需要凑出 11 元，问如何组合才能使硬币的数量最少？
	// 动态规划
	// dp[sum] 表示凑出当前钱数的最少使用硬币数目. dp[sum] = min(dp[sum-1]+1, dp[sum-3]+1, dp[sum-5]+1)
	// 假设有若干，则 dp[sum] = min(dp[sum-coins[0]]+1, dp[sum-coins[1]]+1,...,dp[sum-coins[k]]+1)
	public static int minCoins(int[] coins, int sum) {
		int[] dp = new int[sum+1];
		for (int s = 1; s <= sum; s ++) {
			dp[s] = Integer.MAX_VALUE;
			for (int k = 0; k < coins.length; k ++) {
				if (coins[k] <= s) {
					dp[s] = Math.min(dp[s], dp[s-coins[k]]+1);
				}
			}
		}
		return dp[sum];
	}
	
	
	public static void main(String[] args) {
		coinsComb(8);
		int[] coins = new int[]{1,2,5,10};
		System.out.println(coinsCombDP(coins, 8));
	}
}
