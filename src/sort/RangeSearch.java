package sort;

public class RangeSearch {
	// [34. Search for a Range](https://leetcode.com/problems/search-for-a-range/description/)
	public int searchLeftMost(int[] nums, int target) {
        int l = 0;
        int r = nums.length  - 1;
        int m = -1;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } 
            else if (nums[m] < target) {
                l = m + 1;
            }
            else {
            	if (m == 0) return m;
                if (nums[m] == nums[m-1]) r = m-1;
                else return m;
            }
            System.out.println("l: " + l + ", " + "r: " + r);
        }
        return -1;
    }
    public int searchRightMost(int[] nums, int target) {
        int l = 0;
        int r = nums.length  - 1;
        int m = -1;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } 
            else if (nums[m] < target) {
                l = m + 1;
            }
            else {
            	if (m == (nums.length - 1)) return m;
                if (nums[m] == nums[m+1]) l = m+1;
                else return m;
            }
            System.out.println("l: " + l + ", " + "r: " + r);
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] interval = new int[2];
        interval[0] = searchLeftMost(nums, target);
        System.out.println("-------------");
        interval[1] = searchRightMost(nums, target);
        return interval;
    }
    
    public static void main(String[] args) {
    	int[] a = new int[]{1,1,1,1,1,1};
    	int[] res = new RangeSearch().searchRange(a, 1);
    	System.out.println(res[0]);
    	System.out.println(res[1]);
    }
}
