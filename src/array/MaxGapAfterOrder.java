package array;

import java.util.Arrays;
import java.util.LinkedList;

public class MaxGapAfterOrder {
	// [164. Maximum Gap](https://leetcode.com/problems/maximum-gap/description/)
	
	// 法一 首先排序，然后遍历求差最大 time O(nlgn) space O(1)
	
	// 法二 桶排序 time O(n) space O(n)
	// 桶排序可以看成是hash, 但是这个hash空间利用率很低，没有考虑数据集合分布，直接默认申请了所有空间；
    // 真实的桶排序算法不是这样设计的！！ 他是需要看数据的空间范围，然后重新映射数据到新的空间。桶排序假设数据符合均匀分布，
    // 然后将数据映射到区间 (0,n-1); 具体操作是对数据范围分成 n-1 等分，确定间隔 gap = ceil((max-min)//(n-1));
    // 然后每个数据点 A[i] 就在 bucket[(A[i]-min)/gap] 这个桶上面
    public int maximumGap2(int[] A) {
        // 排序后还是O(n), 必须要用桶排序或，计数排序，基数排序了
        // 首先计算最大最小值确定桶的大小; 然后进行通排序.最后查看;对含有负数的情况是一样的,做一个映射即可; 最后计算连续空桶个数最大的;
        if (A== null || A.length<2) return 0;
        int min = A[0];
        int max = A[0];
        int n = A.length;
        for (int i = 1; i < n; i++) {
            max = Math.max(A[i], max);
            min = Math.min(A[i], min);
        }
        // 桶排序这里只记录每个桶中的最大最小值即可 
        int[] bucketMax = new int[n];
        int[] bucketMin = new int[n];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        
        int gap = (int)Math.ceil((double)(max-min)/(n-1));
        for (int i = 0; i < n; i++) {
            if (A[i] == max || A[i] == min) continue;
            int idx = (A[i] - min) / gap;
            bucketMax[idx] = Math.max(A[i], bucketMax[idx]);
            bucketMin[idx] = Math.min(A[i], bucketMin[idx]);
        }
         
        int i;
        int prev = min;
        int maxDiff = Integer.MIN_VALUE;
        for (i = 0; i < n; i ++) {
            if (bucketMax[i] == Integer.MIN_VALUE && bucketMin[i] == Integer.MAX_VALUE) continue;
            maxDiff = Math.max(maxDiff, bucketMin[i] - prev);
            prev = bucketMax[i];
        }
        maxDiff = Math.max(maxDiff, max-prev);
        return maxDiff;

    }
    
    
    // 法二 采用TreeMap 的方法，有序map。 这样既可以排序，也可以缩小空间使用量。
    
    
    
    // 法三 基数排序 radix sort 
    
	// 法一 Memory Limit Exceeded 因为使用的专门的桶排序，链表数组对象太大
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        LinkedList[] buckets = new LinkedList[max+1];
        for (int i = 0; i < nums.length; i ++) {
            if (buckets[nums[i]] == null) {
                LinkedList<Integer> list = new LinkedList<Integer>();
                buckets[nums[i]] = list;
            }
            buckets[nums[i]].add(nums[i]);
        }
        int i,j;
        for (i = 0; i <= max; i ++) {
            if (buckets[i] != null) break;
        }

        int maxDiff = 0;
        for (; i <= max; ) {
            int diff = 0;
            for (j = i+1; j <= max;j ++) {
                if (buckets[j] == null) {
                    diff ++;
                } else {
                    diff ++;
                    if (diff > maxDiff) {
                        maxDiff = diff;
                    }
                    break;
                }
            }
            i = j;
        }
        return maxDiff;
    }
    
    // 直接使用数组还是不行，因为空间还是太大 比如[1,99999999]
    public int maximumGap1(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int[] buckets = new int[max+1];
        for (int i = 0; i < nums.length; i ++) {
            buckets[nums[i]] ++;
        }
        int i,j;
        for (i = 0; i <= max; i ++) {
            if (buckets[i] != 0) break;
        }

        int maxDiff = 0;
        for (; i <= max; ) {
            int diff = 0;
            for (j = i+1; j <= max;j ++) {
                if (buckets[j] == 0) {
                    diff ++;
                } else {
                    diff ++;
                    if (diff > maxDiff) {
                        maxDiff = diff;
                    }
                    break;
                }
            }
            i = j;
        }
        return maxDiff;
    }
    
}
