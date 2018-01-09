package array;

public class RotateArray {
	public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

     // s: 当前已经完成交换的距离
     // len: 后面子问题的长度
     // k: 右移距离
     
    public void rotate1(int[] nums, int s, int len, int k) {
        if (len <= 1) return; // 长度小于等于1,不用移动
        k = k % len;
        if (k == 0) return; // k == 0 不用移动
        for (int i=0; i<k; i++) {
            // len-k+i 是子问题
            swap(nums, len-k+i+s, i%len+s);
        }
        s += k;
        rotate1(nums, s, nums.length-s, k);
    }
    // SB版本，通过不断的交换！
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (n == 1 || k == 0) return ;
        rotate1(nums, 0, n, k);
    }
    
    // A[1...n-k] reverse A[n-k+1...n] reverse A[1...n] reverse
    public void rotate2(int[] nums, int k) {
    	int n = nums.length;
    	k = k % n;
    	reverse(nums, 0, n-k-1);
    	reverse(nums, n-k, n-1);
    	reverse(nums, 0, n-1);
    }
    public void reverse(int[] nums, int l, int r) {
    	int i,j;
    	i = l; j = r;
    	while (i < j) {
    		swap(nums, i ,j);
    		i ++;
    		j --;
    	}
    }
    
    /**
     * 有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
		给定数组A及它的大小n，请返回最大差值。
		测试样例：
		[10,5],2
		返回：0
     */
    public int getDis(int[] A, int n) {
        int min = A[0];
        int maxDiff = 0;
        for (int i = 1; i < n; i++) {
            maxDiff = Math.max(maxDiff, A[i] - min);
            if (A[i] < min) {
                min = A[i];
            }
        }
        return maxDiff;
    }
    /**
     * 请设计一个复杂度为O(n)的算法，计算一个未排序数组中排序后相邻元素的最大差值。
		给定一个整数数组A和数组的大小n，请返回最大差值。保证数组元素个数大于等于2小于等于500。
		测试样例：
		[9,3,1,10],4
		返回：6
     */
    public int findMaxDivision(int[] A, int n) {
        // 排序后还是O(n), 必须要用桶排序或者计数排序了
        // 首先计算最大最小值确定桶的大小; 然后进行通排序.最后查看;对含有负数的情况是一样的,做一个映射即可; 最后计算连续空桶个数最大的;
        int min = A[0];
        int max = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < min) {
                min = A[i];
            }
        }
        
        // 填桶
        int[] bucket = new int[max-min+1];
        for (int i = 0; i < n; i++) {
            bucket[A[i]-min]++;
        }
        
        // 统计最大连续空桶个数
        int maxDiff = 0;
        for (int i = 0; i < bucket.length; i++) {
            int diff = 0;
            while (i < bucket.length && bucket[i] == 0) {
                diff ++;
                i ++;
            }
            maxDiff = Math.max(maxDiff, diff);
        }
        return maxDiff + 1;
    }
}
