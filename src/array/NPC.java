package array;

import java.util.Arrays;

public class NPC {
	
	public static void main(String[] args) {
		NPC np = new NPC();
		int[] A = {0,0,0,0};
		int n = A.length;
		np.nBits(n, A);
		
		int[] nums = {-2,-3,-1,-7};
		System.out.println(np.isSubSetSum(nums, nums.length-1, -6));
		
		nums = new int[]{3, 2, 7, 1};
		System.out.println(np.isSubSetSumDP(nums, 6));
	}
	
	// T(n) = 2 * T(n-1) + O(1); NP 2^n
	public void nBits(int n, int[] A) {
		if (n <= 0) {
			System.out.println(Arrays.toString(A));
		}
		else {
			A[n-1] = 0;
			nBits(n-1, A);
			A[n-1] = 1;
			nBits(n-1, A);
		}
	}
	
	// NP 2^n。 可以处理含有负数的数组
	public boolean isSubSetSum(int[] A, int end, int target) {
		if (A == null || A.length == 0) return false;
		if (end == 0) return A[0]==target;
		// 如果只处理正数，可以加上这句判断
		/*
		if (target < A[end]) { // 对于处理不含负数的数组，这个判断其实可以不要，加上是为了减少递归调用次数
			return isSubSetSum(A, end-1, target);
		}
		*/
		return isSubSetSum(A, end-1, target-A[end]) || isSubSetSum(A, end-1, target);
	}
	
	// DP, 对于含有负数的数组是不适用的！这里和最大连续数组和一样，只是这里我们不一定要规定是最右端点，原问题可以拆分为子问题包含和不包含，递推公式：
	// dp[i][t] = dp[i-1][t] || dp[i-1][t-A[i-1]]; 如果不只是返回最终是否存在，而是当存在的时候至少返回这几个数，该如何？ backtracing
	// Backtracking | Set 4 (Subset Sum)
	public boolean isSubSetSumDP(int[] A, int target) {
		if (A == null || A.length == 0) return false;
		int n = A.length;
		boolean[][] dp = new boolean[n+1][target+1];
		// target=0 表示不取，则对任意n，都有一种取法即不取，即为真
		for (int i=0;i<=n;i++) {
			dp[i][0] = true;
		}
		for (int t=1;t<=target;t++) { // 没有元素，对任意的正数 target 都是假
			dp[0][t] = false;
		}
		
		for (int i=1; i<=n;i++) {
			for (int t=1; t<=target;t++) {
				if (t>=A[i-1]) {
					dp[i][t] = dp[i-1][t] || dp[i-1][t-A[i-1]];
				}
				else {
					dp[i][t] = dp[i-1][t];
				}
			}
		}
			
		return dp[n][target];
	}
	
	// 416. Partition Equal Subset Sum， 如果是找到两部分，使其尽量相等，即差距最小，如何做？
	public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n,sum=0;
        n = nums.length;
        for (int i=0;i<n;i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        return isSubSetSumDP(nums, sum/2);
    }
}
