package sort;

public class PeakElement {
	// [162. Find Peak Element](https://leetcode.com/problems/find-peak-element/description/)
	//
	public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }
    
    public int findPeakElement1(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int left, right;
        for (int i = 0; i < nums.length; i ++) {
            left = (i-1 == -1 ? Integer.MIN_VALUE : nums[i-1]);
            right = (i+1 == nums.length ? Integer.MIN_VALUE : nums[i+1]);
            if (nums[i] > left && nums[i] > right) return i;
        }
        return -1;
    }
}
