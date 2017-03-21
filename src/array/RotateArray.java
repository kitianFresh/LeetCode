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
    
}
