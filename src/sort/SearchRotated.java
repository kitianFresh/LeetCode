package sort;

public class SearchRotated {
	
	// [33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/description/)
	// 1 2 3 4 5 6 7 8 9  a[m] < a[r] a[m:r] sorted
	// 3 4 5 6 7 8 9 1 2  a[m] > a[r] a[l:m] sorted
	// 8 9 1 2 3 4 5 6 7  a[m] < a[r] 
	public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[high]) {
                if (nums[mid] <= target && nums[high] >= target) low = mid + 1;
                else high = mid - 1;
            }
            else {
                if (nums[mid] >= target && nums[low] <= target) high = mid - 1;
                else low = mid + 1;
            }
        }
        return -1;
    }
	
	// [81. Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/)
	// 当有重复数字，会存在a[m] = a[r]的情况。此时右半序列a[m-1 : r]可能是sorted，也可能并没有sorted，如下例子。
	// 3 1 2 3 3 3 3 
	// 3 3 3 3 1 2 3
	// 因此a[m] = a[r] != target时，无法排除一半的序列，而只能排除掉a[r]. 只能知道 a[r] 一定不是解.
	public boolean search1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) return true;
            if (nums[m] < nums[r]) {
                if (nums[m] <= target && nums[r] >= target) l = m + 1;
                else r = m - 1;
            }
            else if (nums[m] > nums[r]) {
                if (nums[m] >= target && nums[l] <= target)  r = m - 1;
                else l = m + 1;
            }
            // 去除重复的数据,这样就不用考虑那些重复的数的影响, [3,1,1] 3 如果不加入这个, 直接判断 nums[m] >= nums[r] 就断定左边有序而右边无序,
            // 而此时 3 并不满足 3 >=3 && 3 <= 1, 导致条件跳转到 右边去找.
            else {
                r --;
            }
        }
        return false;
    }
	
	// [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/)
	public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int low = 0;
        int high = nums.length - 1;
        int mid = low;
        // 最小值和最大值都在分解点的位置，并且最大值在左，最小值在右
        while (nums[low] >= nums[high]) { // 满足条件则说明旋转过
            mid = (low + high) / 2;
            if (high - low == 1) return nums[high];
            if (nums[mid] >= nums[high]) {
                low = mid;
            }
            else {
                high = mid;
            }
        }
        return nums[mid];
    }
	
	//[154. Find Minimum in Rotated Sorted Array II-hard](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/)
	public int minNumberInRotateArray(int [] array) {
        if (array.length == 1) return array[0];
        int low = 0;
        int high = array.length - 1;
        int mid = high;
        while (array[low] >= array[high]) {
            mid = (low + high) / 2;
            if (high - low == 1) return array[high];
            if (array[mid] == array[high] && array[mid] == array[low]) { // 针对有重复数据的情况，无法判断mid属于左边还是右边，需要顺序求解
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
