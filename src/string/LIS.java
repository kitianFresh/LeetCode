package string;

import java.util.Arrays;

public class LIS {
	// [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/#/description)
	public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] lis = new int[n];// 表示以 i 结束的最长递增序列
        
        for (int i = 0; i < n; i++) lis[i] = 1;// 初始时候都是1
        
        int max = lis[0];
        for (int i = 1; i < n; i++) {
            int maxcur = lis[i];
            for (int j = i - 1; j >= 0;  j--) { // 往前查看所有的可能, 只要nums[i]>nums[j], 就可以加入
                if (nums[i] > nums[j]) {
                    maxcur = Math.max(maxcur, lis[j] + 1);
                }
            }
            lis[i] = maxcur;
            max = Math.max(max, lis[i]);
        }
        return max;
    }
	
	// 现在 lis[i] 存储的是长度为 i 的lis 的最后一个元素值, 根据长度为 i 的lis 最后一个值一定不小于 长度为 i-1 的lis 最后一个值这一事实, 
	//我们可以构造出一个递增的lis数组, 然后使用二分查找寻找插入点, 并更新更小的值, 即更新点位置的元素将被替换为新的更小的元素,
	// 这样后面未加入的元素才有更大的可能能够增加lis的长度;
	// Space O(n); Time O(nlgn)
	public int lengthOfLISOptimal(int[] nums) {
		int n = nums.length;
        int[] lis = new int[n];// 初始化为全0
        int len = 0;// lis 中元素个数, 即lis 长度;
        
        int insertPoint;
        for (int i = 0; i < n; i++) {
            insertPoint = Arrays.binarySearch(lis, 0, len, nums[i]);
            if (insertPoint < 0) {
            	insertPoint = -(insertPoint + 1);
            }
            lis[insertPoint] = nums[i];
            if (insertPoint == len) {
            	len ++;
            }
        }
        return len;
	}
}
