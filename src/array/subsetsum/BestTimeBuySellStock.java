package array.subsetsum;

public class BestTimeBuySellStock {
	// 滚动扫描法123. Best Time to Buy and Sell Stock III
	
	// 123. Best Time to Buy and Sell Stock III
	// 因为两次交易,因此必定可以分成两个区间,左右区间的交易之和最大即可.就是需要找出所有的区间划分,然后比较每个区间划分的最大收益. 如果直接 遍历 i 个分界点, 然后左右区间使用最大子数组求,那么时间复杂度是 O(n^2)
    // 这里使用 DP ,分别算出所有的 i 的左边(包含i)区间的最大收益, 再从右到左算出 所有的 i 的右边(包含i)区间的最大收益,这样就记录下来所有的区间组合的最大收益了,最后比较所有的区间组合最大收益即可,时间复杂度 O(n), 空间复杂度 O(n)
    public int maxProfitIII(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int min = Integer.MAX_VALUE;
        int leftProfit = 0;
        for (int i=0; i<n; i++) {
           min = Math.min(prices[i], min);
           leftProfit = Math.max(prices[i] - min, leftProfit);
           left[i] = leftProfit;
        }
        int rightProfit = 0;
        int max = Integer.MIN_VALUE;
        for (int i=n-1; i>=0; i--) {
            max = Math.max(prices[i], max);
            rightProfit = Math.max(max-prices[i], rightProfit);
            right[i] = rightProfit;
        }
        max = 0;
        for (int i=0; i<n; i++) {
            max = Math.max(left[i]+right[i], max);
        }
        return max;
    }
	
	
	//122. Best Time to Buy and Sell Stock II
	public int maxProfitII(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int max = 0;
        int diff = 0;
        for (int i=1; i < prices.length; i++) {
            diff = prices[i] - prices[i-1];
            if (diff > 0) {
                max += diff;
            }
        }
        return max;
    }
	
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
	
	// 121. Best Time to Buy and Sell Stock
	// 最大利润应该等于低价买入，高价卖出，即时间序列是 max (prices[t] - prices[t']),t>t'; 
	// 想要找到最大的利润，需要从后往前扫描所有的差进行比较，显然暴力解法达到 O(n^2)。我们可以根据结论找条件的方法，来看看这个问题是否可以进一步转化！
	// 因为 prices[j] - prices[i] = prices[j] - prices[j-1] + prices[j-1] - prices[j-2] + ... + prices[i+1] - prices[i],（其中 j>i）;
	// 使用diffs[i] 表示 第 i+1 天和第 i 天的差价，则 prices[j] - prices[i] = diffs[j-1] + diffs[j-2] + ... + diffs[i],
	// 如果 prices[j] - prices[i] 最大，则必有 diffs[j-1] + diffs[j-2] + ... + diffs[i] 最大，两者等价，即问题变换为求最大连续子数组和。
	public int maxProfitI(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int[] diffs = new int[prices.length-1];
        for (int i=0;i<prices.length-1;i++) {
            diffs[i] = prices[i+1] - prices[i];
        }
        return maxSubArray(diffs);
    }
    // 该方法更加简洁,只使用 O(n) 时间, O(1)空间! 其实我们可以思考, 最大收益必定是 某一天卖出,我们假设是第 i 天, 那么采用动态规划只需要知道前面的最小股价即可求出最大差价了!
	public int maxProfit(int[] prices) {
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i=0; i < prices.length; i++) {
		    min = Math.min(prices[i], min);
		    max = Math.max(prices[i] - min, max);
		}
		return max;
	}
}
