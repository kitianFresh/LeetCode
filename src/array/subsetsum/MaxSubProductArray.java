package array.subsetsum;

public class MaxSubProductArray {
	public static void main(String[] args) {
		MaxSubProductArray msa = new MaxSubProductArray();
		int[] nums = {-4,-3,-2};
		System.out.println(msa.maxProduct(nums));
	}
	// 实际上不用考虑那么细节，我们只需要知道最大值就行，拿出来比较一下即可！因为负数 * 负数 更大，因此前面要记录 负数最小值以及正数最大值，也就是最小值（尽管不是负数也没关系，我们只是比较最大值）和最大值；最大值一定在 maxPre*nums[i],minPre*nums[i],nums[i] 中取得
    public int maxProductElegant(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxCur, minCur, maxPre, minPre, max;
        max = maxCur = minCur = maxPre = minPre = nums[0];
        for (int i=1; i<nums.length; i++) {
            maxCur = Math.max(Math.max(maxPre*nums[i], minPre*nums[i]), nums[i]);
            minCur = Math.min(Math.min(maxPre*nums[i], minPre*nums[i]), nums[i]);
            max = Math.max(max, maxCur);
            maxPre = maxCur;
            minPre = minCur;
        }
        return max;
    }
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
        int dpMinus, dpPlus, tempMinus, tempPlus;
        tempMinus = dpMinus = nums[0]<=0?nums[0]:1; // Minus 1 表示前面没有负数累积
        tempPlus = dpPlus = nums[0]>=0?nums[0]:-1; // Plus -1 表示前面没有正数累积
        
        // 同时为 0 表示 上一个元素是0
        int max = nums[0];
        // System.out.println("dpMinus: " + dpMinus + "\t" + "dpPlus: " + dpPlus);
        // System.out.println(max);
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > 0) {
                if (dpPlus == 0 && dpMinus == 0) {          // 前面为0
                    dpPlus = nums[i];
                    dpMinus = 1;
                }
                else {
                    dpPlus = tempPlus==-1?nums[i]:(tempPlus * nums[i]); // nums[i]为正数，现在的dpPlus，如果前一个Plus没有，则取nums[i] 自己，有则取相乘
                    dpMinus = tempMinus==1?1:(tempMinus*nums[i]);       // nums[i]为正数，现在的dpMinus,如果前一个Minus没有，则取1没有，有则取相乘
                }
            }
            else if (nums[i] < 0) {
                if (dpPlus == 0 && dpMinus == 0) {
                    dpPlus = -1;
                    dpMinus = nums[i];
                }
                else {
                    dpPlus = (tempMinus==1)?1:(tempMinus * nums[i]);
                    dpMinus = (tempPlus==-1)?nums[i]:(tempPlus * nums[i]);
                }
            }
            else {
                dpPlus = dpMinus = 0;
            }
            tempPlus = dpPlus;
            tempMinus = dpMinus;
            // System.out.println("dpMinus: " + dpMinus + "\t" + "dpPlus: " + dpPlus);
            // System.out.println(max);
            max = Math.max(max, dpPlus);
        }
        return max;
    }
	
	
	// 大多数dp问题，如果不需要借助中间结果进行回溯，其实都可以对空间进行优化操作，例如这里直接将空间复杂度从 O(n) 降低到 O(1),时间复杂度 O(n) 不变；
	public int maxSubArrayDpOptimal(int[] nums) {
		int dp, max = nums[0];
		dp = nums[0];
		for (int i=1;i<nums.length;i++) {
			dp = nums[i] + (dp>0?dp:0); // 三目运算符一定要加括号
			max = Math.max(max, dp);
		}
		return max;
	}
	
	// dp 编程，时间复杂度 O(n), 空间复杂度 O(n), 
	// 寻找问题规模为 n 和 n-1 之间的联系，并不一定要存储最大值，这里DP的递推公式下标选择标准是end，即存储以end为右边界的子数组的和，
	// 然后比较大小即可，因为最大子数组一定是以某一个end为右边界！，基于这个事实，我们就可以得到递推公式；
	// dp[end] = (dp[end-1]>0?dp[end-1]:0) + array[end];
	// 如果要返回最大子数组的左右边界，我们需要在求出右边界后保存，然后再从该右边界向前遍历即可
	public int maxSubArrayDp(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int end = nums.length - 1;
		int[] dp = new int[end+1];
		int max = dp[0] = nums[0];
		for (int i=1;i<=end;i++) {
			dp[i] = nums[i] + (dp[i-1]>0?dp[i-1]:0); // 三目运算符一定要加括号
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	
	// 均匀分治法，时间复杂度 O(nlgn),递归压栈的空间复杂度 O(clgn) 。可以很容易保存最大子数组的左右边界。最大子数组三种可能： left half，right half，mid included.
	// 算法主要是合并过程，需要找出mid included 的最大子数组，此时问题又可以分成左右两部分，然后求和！ T(n) = 2T(n/2)+O(n)
	public int maxSubArray(int[] array, int start, int end) {
        if (array == null || array.length == 0 || start > end) return 0;
        if (start == end) return array[start];
        int mid = (start+end)/2;
        int left = maxSubArray(array, start, mid);
        int right = maxSubArray(array, mid+1, end);
        int i;
        int sum=0;
        int leftSum = Integer.MIN_VALUE;
        for (i=mid;i>=start;i--) {
            sum += array[i];
            if (sum>leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (i=mid+1;i<=end;i++) {
            sum += array[i];
            if (sum>rightSum) {
                rightSum = sum;
            }
        }
        sum = leftSum + rightSum;
        return Math.max(Math.max(left,right), sum);
        
    }
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums,0,nums.length-1);
    }
}
