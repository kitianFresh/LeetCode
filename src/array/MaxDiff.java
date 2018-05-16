package array;

public class MaxDiff {
	// [牛客网-有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。给定数组A及它的大小n，请返回最大差值。](https://www.nowcoder.com/practice/1f7675ae7a9e40e4bd04eb754b62fd00?tpId=49&tqId=29281&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2F2016test%2Fquestion-ranking&tPage=1)
	// 本来是 dp[n] dp[i] 表示当前元素A[i]和当前最小值的差，那么所有的差值取最大的即可！但是这种类型的dp旺旺可以优化， 二维变一维，一维变0维
    public int getDis(int[] A, int n) {
        // write code here
        if (n == 0) return 0;
        int min = A[0];
        int maxDiff = 0;
        for (int i = 0; i < n; i ++) {
            min = Math.min(min, A[i]); // 当前最小值
            maxDiff = Math.max(maxDiff, A[i]-min); // 当前元素和最小值的差 和 当前最大差值比较，取较大者
        }
        return maxDiff;
    }
    
    
    // [题目：在数组中，数字减去它右边的数字得到一个数对之差。求所有数对之差的最大值。例如在数组{2, 4, 1, 16, 7, 5, 11, 9}中，数对之差的最大值是11，是16减去5的结果。](http://zhedahht.blog.163.com/blog/static/2541117420116135376632/)
    // 此题目就是最大差值倒过来了，从后面往前寻找当前值和前面(不包含当前值)最小值的差值，取所有差值最小的一个。
    // 此题还有分治法，转化为连续和最大的子数组
    public int getDisNumPairs(int[] A, int n) {
    	if (n < 2) return 0;
    	int min = A[n-1];
    	int maxDiff = 0;
    	for (int i = n - 2; i >= 0; i --) {
    		maxDiff = Math.max(maxDiff, A[i]-min);
    		min = Math.min(A[i], min);
    	}
    	return maxDiff;
    }
    
    public static void main(String[] args) {
        MaxDiff solution = new MaxDiff();
        int[] nums = {1, 2, 10, 4, 100, 5, 6, 6};
        int[] nums1 = {1,2,3,4,5,6,7,8,9};
        int[] nums2 = {9,8,7,6,5,4,3,2};
        int[] nums3 = {2,2,2,2};
        System.out.println(solution.getDisNumPairs(nums, 8));
        System.out.println(solution.getDisNumPairs(nums1, 9));
        System.out.println(solution.getDisNumPairs(nums2, 8));
        System.out.println(solution.getDisNumPairs(nums3, 4));
    }
    
}