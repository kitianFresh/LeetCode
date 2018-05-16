package swordoffer;

import java.util.ArrayList;

public class MaxSubArray {
	// [连续子数组的最大和](https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	public int FindGreatestSumOfSubArray(int[] array) {
        int n = array.length;
        int[] dp = new int[n];
        dp[0] = array[0];
        for (int i = 1; i < n; i ++) {
            dp[i] = dp[i-1] > 0 ? dp[i-1] + array[i] : array[i];
        }
        int max = dp[0];
        for (int i = 1; i < n; i ++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
	
	// [和最大的连续子数组]
	public ArrayList<Integer> FindGreatestSumOfSubArray1(int[] array) {
        int n = array.length;
        int[] dp = new int[n];
        dp[0] = array[0];
        for (int i = 1; i < n; i ++) {
            dp[i] = dp[i-1] > 0 ? dp[i-1] + array[i] : array[i];
        }
        int max = dp[0];
        int maxLastIndex = 0;
        for (int i = 1; i < n; i ++) {
            if (max < dp[i]) {
                max = dp[i];
                maxLastIndex = i;
            }
        }
        int maxFirstIndex = maxLastIndex;
        while (maxFirstIndex >= 0) {
        	if (dp[maxFirstIndex] > 0) maxFirstIndex --;
        	else break;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = maxFirstIndex; i <= maxLastIndex; i++) {
        	res.add(array[i]);
        }
        return res;
    }
	
	// [子序列的最大和(子序列可以连续可以不连续)]
	
	// [和最大的子序列]
	
	// [子序列的最大和(子序列中任意相邻的两个数在原序列里都不相邻)]
	
	// [连续子数组的最大乘积] [152. Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/description/)
	// [乘积最大的连续子数组]
	// [628. Maximum Product of Three Numbers](https://leetcode.com/problems/maximum-product-of-three-numbers/description/)
	// [713. Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k/description/)
	// [238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/description/)
	// [697. Degree of an Array](https://leetcode.com/problems/degree-of-an-array/description/)
	
	// [子序列的最大乘积]
	
	// [乘积最大的连续子序列]
}
