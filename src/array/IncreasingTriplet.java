package array;

public class IncreasingTriplet {
	// [334. Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/description/)
	
	// 法一, 动态规划, 使用数组 dp 记录比当前元素小的元素个数, dp[i] 表示 nums 比第 i 个元素 nums[i] 小的元素的个数;
	// 当 dp[i] 满足 nums[j] < nums[i] &&  dp[i] = max(dp[i], dp[j]+1) j < i; 且 dp[i] >= 2 的时候, 即满足要求
	// time O(n^2) ; space O(n)
	public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >= 0; j --) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    if (dp[i] >= 2) return true;
                }
            }
        }
        return false;
    }
	// 法二; 采用经典的双向数组纪序法, 正向 forwards[i] 表示正向从 0,1,...到 i 的最小值, 
	// backwards[j] 表示逆向从 n n-1,... 到　j 的当前最大值；　那么当满足　forwards[k] < nums[k] < backwards[k] 时，必定存在这样一个triplet
	// time O(n); space O(n)
	public boolean increasingTriplet1(int[] nums) {
		if (nums == null || nums.length < 3) return false;
        int len = nums.length;
        int[] forwards = new int[len];
        forwards[0] = nums[0];
        int[] backwards = new int[len];
        backwards[len-1] = nums[len-1];
        for (int i = 1; i < len; i ++) {
            forwards[i] = Math.min(forwards[i-1], nums[i]);
        }
        for (int j = len - 2; j >= 0; j --) {
            backwards[j] = Math.max(backwards[j+1], nums[j]);
        }
        for (int k = 1; k < len - 1; k++) {
            if (nums[k] > forwards[k] && nums[k] < backwards[k]) {
                return true;
            }
        }
        return false;
	}
	
	// 法三. ！！注意该方法和求当前第一第二小元素的区别！！　采用两个变量 m1 m2 纪录到目前为止第一第二小的
	// 满足 m1 < m2 且　m1 在　m2 之前的两个数，如果后续能找到第三个数比他们都大，那么就存在 triplet
	public boolean increasingTriplet2(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int m1, m2;
        m1 = m2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (m1 >= num) m1 = num;
            else if (m2 >= num) m2 = num;
            else return true;
        }
        return false;
    }
}
