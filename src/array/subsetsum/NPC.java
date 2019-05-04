package array.subsetsum;

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
	
	public void nChars(StringBuilder sb, String result, int len) {
		if (len == sb.length()) {
			System.out.println(result);
		}
		else {
			for (int i = len; i < sb.length(); i++) {
				
			}
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
	// subset sum can be reduced to equal partition, https://cs.stackexchange.com/questions/6111/how-can-i-reduce-subset-sum-to-partition
	// 一个集合L 可以被划分成 两个元素之和相等的集合 问题 <==> 一个集合 L 中是否存在 一个子集, 他的元素之和等于某个数
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
	
	// Partition a set into two subsets such that the difference of subset sums is minimum
	// NP 完全问题, 只存在近似解或者 采用 伪多项式 时间解决,即dp,但是dp大小和输入的和有关
	// sum1 + sum2 = sum; min(abs(sum1 - sum2)). 假设 sum1 >= sum2, 则 sum1 - sum/2 = sum/2 - sum2;
	// 问题也可以转换为 0 1背包, 就是在 sum/2 的容量下, 找到累计价值sum1越大越好! c = sum/2; 最后比较 sum1 和 sum2
	// dp[i][j] 表示前i个元素,放进容量为 j 的背包的最大价值数. dp[i][j] = max(dp[i-1][j-a[i]]+a[i], dp[i-1][j]), 这里的价值也是重量本身
	public int minDiffPartition(int[] a) {
		if (a == null || a.length < 1) return 0;
		int n = a.length;
		int sum = 0;
		for (int i=0; i<n; i++) {
			sum += a[i];
		}
		int[][] dp = new int[n+1][sum/2+1];
		for (int i=1; i < n + 1; i++) {
			for (int j=1; j< sum/2 + 1; j++) {
				if (j >= a[j-1]) {
					dp[i][j] = Math.max(dp[i-1][j-a[i-1]]+a[i], dp[i-1][j]);
				}
			}
		}
		return Math.abs(sum - dp[n][sum/2]- dp[n][sum/2]);
	}
	
	// 递归写法 时间复杂度 O(2^n). 最后选出来的两个集合,必定一个包含 a[i], 一个不包含 a[i], 
	// 对于包含 a[i] 的情况,子问题就是 minDiffPartitionRecursion(a, i-1, calculatedSum+a[i], totalSum)
	// 对于不包含 a[i] 的情况, 子问题就是 minDiffPartitionRecursion(a, i-1, calculatedSum, totalSum)
	// 问题可以划分为
	public int minDiffPartitionRecursion(int[] a, int i, int calculatedSum, int totalSum) {
		if (i == 0) {
			return Math.abs(totalSum - calculatedSum - calculatedSum);
		}
		return Math.min(minDiffPartitionRecursion(a, i-1, calculatedSum+a[i], totalSum),
						minDiffPartitionRecursion(a, i-1, calculatedSum, totalSum));
	}
	
	int findMin(int arr[], int n)
	{
	    // Compute total sum of elements
	    int sumTotal = 0;
	    for (int i=0; i<n; i++)
	        sumTotal += arr[i];
	 
	    // Compute result using recursive function
	    return minDiffPartitionRecursion(arr, n, 0, sumTotal);
	}
}
