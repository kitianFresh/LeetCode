package swordoffer;

import java.util.ArrayList;

public class MaxSubArray {
	// [连续子数组的最大和](https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	// dp[i] 表示当前包含元素 a[i] 作为末尾元素的连续子数组和，对于 dp[i] = dp[i-1] > 0 ? dp[i-1] +
	// array[i] : array[i]; 选出最大的 dp[i] 即可
	public int FindGreatestSumOfSubArray(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int n = array.length;
		int[] dp = new int[n];
		dp[0] = array[0];
		int max = dp[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
			max = Math.max(dp[i], max);
		}
		return Math.max(0, max); // 全为负数，最大和为0，即不选择
	}

	// 改进 其实 dp[i] 是不需要全部记录的，这又是dp编程，只求结果不求过程的时候，二维降一维，一维降零维的例子
	// 每次我们直接记录前面的最大的连续子数组和即可。最大子数组和小于0的时候，当前最大子数组是不可能加上curMax的，因为越加越小。
	public int FindGreatestSumOfSubArray1(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int n = array.length;
		int[] dp = new int[n];
		dp[0] = array[0];
		int curMax = dp[0];
		int maxSum = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			if (curMax > 0) {
				curMax += array[i];
			} else {
				curMax = array[i];
			}
			maxSum = Math.max(curMax, maxSum);
		}
		return Math.max(maxSum, 0); // 全为负数，最大和为0，即不选择
	}

	// [和最大的连续子数组]
	// 需要记录下来最大连续子数组是哪里，由于是连续的，我们已知和最大连续子数组的末尾元素位置，然后往前推算即可
	public ArrayList<Integer> FindSubArrayOfGreatestSum(int[] array) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (array == null || array.length == 0)
			return res;
		int n = array.length;
		int[] dp = new int[n];
		dp[0] = array[0];
		int max = dp[0];
		int maxLastIndex = 0;
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
			if (dp[i] > max) {
				max = dp[i];
				maxLastIndex = i;
			}
		}
		int maxFirstIndex = maxLastIndex;
		while (maxFirstIndex >= 0 && dp[maxFirstIndex] > 0) {
			maxFirstIndex--;
		}
		maxFirstIndex++;

		for (int i = maxFirstIndex; i <= maxLastIndex; i++) {
			res.add(array[i]);
		}
		
//		for (Integer i : res) {
//			System.out.print(i);
//		}
//		System.out.println();
		return res;
	}

	// [子序列的最大和(子序列可以连续可以不连续)]
	// 现在问题是子序列，注意不一定是连续的. 显然，如果我们选择所有的正数元素相加，肯定是和最大的！
	public int MaxSumOfSubSequence(int[] array) {
		int max = array[0];
		int maxSum = 0;
		for (int i = 0; i < array.length; i++) {
			max = Math.max(array[i], max);
			if (array[i] >= 0) {
				maxSum += array[i];
			}
		}

		return max > 0 ? maxSum : max;
	}

	// 另一种分析方法还是dp，假设dp[i]表示到第i个元素为止，当前最大的子序列和，
	// 那么 dp[i] = max(array[i], dp[i-1], dp[i-1]+array[i]); 这里注意和连续子序列和的区别
	//
	public int MaxSumOfSubSequenceDP(int[] array) {
		int n = array.length;
		int[] dp = new int[n];
		int max = array[0];
		dp[0] = array[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(array[i], Math.max(dp[i-1], dp[i-1]+array[i]));
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	
	// [非连续子序列的最大和(子序列中任意相邻的两个数在原序列里都不相邻)]
	// 和子序列问题类似，dp[i] = max(array[i], dp[i-1], dp[i-2]+array[i])
	public int  MaxSumOfNoCongSubSequence(int[] array) {
		int n = array.length;
		if (n == 0) return 0;
		if (n == 1) return array[0];
		if (n == 2) return Math.max(array[0], array[1]);
		int[] dp = new int[n];
		dp[0] = array[0];
		dp[1] = Math.max(array[0], array[1]);
		int max = Math.max(dp[0], dp[1]);
		for (int i = 2; i < n; i ++) {
			dp[i] = Math.max(Math.max(dp[i-2]+array[i], dp[i-1]), array[i]);
			max = Math.max(dp[i], max);
		}
		return Math.max(max,0);
	}

	// [和最大的子序列]
	public ArrayList<Integer> SubSequenceOfMaxSum(int[] array) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int max = array[0];
		int maxSum = 0;
		for (int i = 0; i < array.length; i++) {
			max = Math.max(array[i], max);
			if (array[i] > 0) {
				maxSum += array[i];
				res.add(array[i]);
			}
		}
		return res;
	}

	// [连续子数组的最大乘积] [152. Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/description/)
	public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max;
        max = nums[0];
        for (int i = 1; i < n; i ++) {
            dpMax[i] = Math.max(Math.max(dpMax[i-1]*nums[i], dpMin[i-1]*nums[i]), nums[i]);
            dpMin[i] = Math.min(Math.min(dpMax[i-1]*nums[i], dpMin[i-1]*nums[i]), nums[i]);
            max = Math.max(dpMax[i], max);
        }
        return max;
    }
	// [乘积最大的连续子数组]
	
	
	// [628. Maximum Product of Three Numbers](https://leetcode.com/problems/maximum-product-of-three-numbers/description/)
	// [713. Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k/description/)
	// [238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/description/)
	// [697. Degree of an Array](https://leetcode.com/problems/degree-of-an-array/description/)

	// [子序列的最大乘积]

	// [乘积最大的连续子序列]
	
	public static void main(String[] args) {
		MaxSubArray msa = new MaxSubArray();
		int[] a1 = new int[]{-3,-1,-5,7,-2,1};
		int[] a2 = new int[]{-5,-3,-1,-2,-4,-6};
		int[] a3 = new int[]{1,2,3,4,5,6};
		int[] a4 = new int[]{1,-1,2,-2,3,-3};
		int[] a5 = new int[]{-4,4,-5,5,-1,1};
		int[] a6 = new int[]{0,0,0,0,0,0};
		
		System.out.println("---------------------MaxSumOfSubSequenceDP---------------------");
		System.out.println(msa.MaxSumOfSubSequenceDP(a1));
		System.out.println(msa.MaxSumOfSubSequenceDP(a2));
		System.out.println(msa.MaxSumOfSubSequenceDP(a3));
		System.out.println(msa.MaxSumOfSubSequenceDP(a4));
		System.out.println(msa.MaxSumOfSubSequenceDP(a5));
		System.out.println(msa.MaxSumOfSubSequenceDP(a6));
		
		System.out.println("---------------------MaxSumOfSubSequence---------------------");
		System.out.println(msa.MaxSumOfSubSequence(a1));
		System.out.println(msa.MaxSumOfSubSequence(a2));
		System.out.println(msa.MaxSumOfSubSequence(a3));
		System.out.println(msa.MaxSumOfSubSequence(a4));
		System.out.println(msa.MaxSumOfSubSequence(a5));
		System.out.println(msa.MaxSumOfSubSequence(a6));
		
		System.out.println("---------------------FindSubArrayOfGreatestSum---------------------");
		System.out.println(msa.FindSubArrayOfGreatestSum(a1));
		System.out.println(msa.FindSubArrayOfGreatestSum(a2));
		System.out.println(msa.FindSubArrayOfGreatestSum(a3));
		System.out.println(msa.FindSubArrayOfGreatestSum(a4));
		System.out.println(msa.FindSubArrayOfGreatestSum(a5));
		System.out.println(msa.FindSubArrayOfGreatestSum(a6));
		
		System.out.println("---------------------FindGreatestSumOfSubArray---------------------");
		System.out.println(msa.FindGreatestSumOfSubArray(a1));
		System.out.println(msa.FindGreatestSumOfSubArray(a2));
		System.out.println(msa.FindGreatestSumOfSubArray(a3));
		System.out.println(msa.FindGreatestSumOfSubArray(a4));
		System.out.println(msa.FindGreatestSumOfSubArray(a5));
		System.out.println(msa.FindGreatestSumOfSubArray(a6));
		
		System.out.println("---------------------FindGreatestSumOfSubArray1---------------------");
		System.out.println(msa.FindGreatestSumOfSubArray1(a1));
		System.out.println(msa.FindGreatestSumOfSubArray1(a2));
		System.out.println(msa.FindGreatestSumOfSubArray1(a3));
		System.out.println(msa.FindGreatestSumOfSubArray1(a4));
		System.out.println(msa.FindGreatestSumOfSubArray1(a5));
		System.out.println(msa.FindGreatestSumOfSubArray1(a6));
		
		System.out.println("---------------------MaxSumOfNoCongSubSequence---------------------");
		System.out.println(msa.MaxSumOfNoCongSubSequence(a1));
		System.out.println(msa.MaxSumOfNoCongSubSequence(a2));
		System.out.println(msa.MaxSumOfNoCongSubSequence(a3));
		System.out.println(msa.MaxSumOfNoCongSubSequence(a4));
		System.out.println(msa.MaxSumOfNoCongSubSequence(a5));
		System.out.println(msa.MaxSumOfNoCongSubSequence(a6));
		
		System.out.println("---------------------SubSequenceOfMaxSum---------------------");
		System.out.println(msa.SubSequenceOfMaxSum(a1));
		System.out.println(msa.SubSequenceOfMaxSum(a2));
		System.out.println(msa.SubSequenceOfMaxSum(a3));
		System.out.println(msa.SubSequenceOfMaxSum(a4));
		System.out.println(msa.SubSequenceOfMaxSum(a5));
		System.out.println(msa.SubSequenceOfMaxSum(a6));
	}
	
}
