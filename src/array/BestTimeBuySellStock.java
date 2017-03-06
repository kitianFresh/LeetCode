package array;

public class BestTimeBuySellStock {
	// 由于价差为负数肯定没有意义，因此和 MaxSubArray 稍有不同的是 max<0 时，直接返回0
	public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int dp = nums[0];
        int max = nums[0];
        for (int i=1;i<nums.length;i++) {
            dp = nums[i] + (dp>0?dp:0);
            max = Math.max(max, dp);
        }
        return max>0?max:0;
    }
	
	// 最大利润应该等于低价买入，高价卖出，即时间序列是 max (prices[t] - prices[t']),t>t'; 
	// 想要找到最大的利润，需要从后往前扫描所有的差进行比较，显然暴力解法达到 O(n^2)。我们可以根据结论找条件的方法，来看看这个问题是否可以进一步转化！
	// 因为 prices[j] - prices[i] = prices[j] - prices[j-1] + prices[j-1] - prices[j-2] + ... + prices[i+1] - prices[i],（其中 j>i）;
	// 使用diffs[i] 表示 第 i+1 天和第 i 天的差价，则 prices[j] - prices[i] = diffs[j-1] + diffs[j-2] + ... + diffs[i],
	// 如果 prices[j] - prices[i] 最大，则必有 diffs[j-1] + diffs[j-2] + ... + diffs[i] 最大，两者等价，即问题变换为求最大连续子数组和。
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int[] diffs = new int[prices.length-1];
        for (int i=0;i<prices.length-1;i++) {
            diffs[i] = prices[i+1] - prices[i];
        }
        return maxSubArray(diffs);
    }
    
}
