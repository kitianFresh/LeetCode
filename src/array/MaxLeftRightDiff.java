package array;

public class MaxLeftRightDiff {
	
	// [牛客-左右最值最大差](https://www.nowcoder.com/practice/f5805cc389394cf69d89b29c0430ff27?tpId=49&&tqId=29359&rp=1&ru=/activity/oj&qru=/ta/2016test/question-ranking)
	// 法一 双数组法，double scan， time O(n); space O(n)
    public int findMaxGap(int[] A, int n) {
        // write code here
        if (n < 2) return 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int max = Integer.MIN_VALUE;
        int i, j;
        for (i = 0; i < n; i ++) {
            max = Math.max(A[i], max);
            leftMax[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (j = n - 1; j >= 0; j -- ) {
            max = Math.max(A[j], max);
            rightMax[j] = max;
        }
        int maxDiff = 0;
        for (i = 0; i < n; i ++) {
            maxDiff = Math.max(maxDiff, Math.abs(leftMax[i]-rightMax[i]));
        }
        return maxDiff;
    }
    
    // 法二 注意这个题目的特殊性，其实最大差值 一定是 最大值减去某个最小值(左右部分的)， 为什么一定包含最大值？ 
    // 反证法，假设最后的解不包含最大值，那么左边或者右边的最大值就没有使用，不符合左边最大和右边最大的题意。
    // 第二，一旦确定一个部分的最大值（即全局最大值）。那么，另一部分一定会包括一个端点，左端点或者右端点，我们假设左端点
    // 左端点如果比后面的数大，无疑，这个数一定是左边最大值了，不能还取一个比他还大的值；如果左端点比后面的数小，就更得取左端为左边最大值了，因为一旦加入一个值比他大，那左边最大值就更大了
    // 右边同理，综上，我们只需要比较 A[pos] - A[n-1] 和 A[pos] - A[0] 的较大值即可。
    // 6,3,4,7,1,5,3 A[pos] - A[n-1]， A[pos] - A[0]
    // 7,4,3,3,1,5,6 A[pos] - A[n-1]
    // 7,3,6,3,1,5,1 A[pos] - A[n-1]
    // 1,5,1,3,6,3,7 A[pos] - A[0]
    public int findMaxGap1(int[] A, int n) {
        // write code here
        if (n < 2) return 0;
        int max = Integer.MIN_VALUE;
    	int pos = 0;
    	for (int i = 0; i < n; i ++) {
    		if (A[i] > max) {
    			pos = i;
                max = A[i];
    		}
    	}
    	return Math.max(A[pos] - A[0], A[pos] - A[n-1]);
    }
}
