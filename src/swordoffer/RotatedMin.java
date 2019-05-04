package swordoffer;

public class RotatedMin {
	// [81. Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/)
	public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int l = 0;
        int r = nums.length - 1;
        int m;
        while (l <= r) {
            m = (l + r) / 2; 
            if (nums[m] == target) return true;
            int low, high;
            if (nums[m] >=nums[l]) {
                if(nums[m] == nums[l]){
                    l++;
                }
                else{
                    if (nums[l] <= target && target < nums[m]) {
                        r = m - 1;
                    }
                    else {
                        l = m + 1;
                    }
                }
            }
            else {
                if (nums[m] == nums[r]){
                    r--;
                } 
                else{
                    if (nums[m] < target && target <= nums[r]) {
                        l = m + 1;
                    }
                    else {
                        r = m - 1;
                    }
                }
            }
        }
        return false;
    }
	// [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/)
	public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int m;
        while (l + 1 < r) {
            m = (l + r) / 2;
            if (nums[m] > nums[l]) {
                l = m;
            }
            else if (nums[m] < nums[r]) {
                r = m;
            }
        }
        
        return Math.min(nums[0], Math.min(nums[l], nums[r]));
    }
	
	
	// [154. Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/)
	public int findMinII(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int m;
        while (l + 1 < r) {
            while (r > 0 && nums[r] == nums[r-1]) r --;
            while (l < n-1 && nums[l] == nums[l+1]) l ++;
            m = (l + r) / 2;
            if (nums[m] > nums[l]) {
                l = m;
            }
            else if (nums[m] < nums[r]) {
                r = m;
            }
        }
        return Math.min(nums[0], Math.min(nums[l], nums[r]));
    }
	
	public int minNumberInRotateArray(int [] array) {
        if (array.length == 1) return array[0];
        int low = 0;
        int high = array.length - 1;
        int mid = high;
        while (array[low] >= array[high]) {
            mid = (low + high) / 2;
            if (high - low == 1) return array[high];
            if (array[mid] == array[high] && array[mid] == array[low]) {
                return minOrder(array, low, high);
            }
            if (array[mid] >= array[high]) {
                low = mid;
            }
            else if (array[mid] <= array[high]) {
                high = mid;
            }
        }
        return array[mid];
    }
    public int minOrder(int[] array, int low, int high) {
        int min = array[low];
        for (int i = low + 1; i <= high; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
