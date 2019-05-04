package sort;

public class FindKLargest {
	public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        return findK(nums, 0, nums.length-1, k);
    }
    
    public int findK(int[] nums, int left, int right, int k) {
        //System.out.println(left+ ":" +right + ":" + k);
        int pos = partition(nums, left, right);
        if (pos - left + 1 == k) return nums[pos];
        else if (pos - left + 1 < k) {
            return findK(nums, pos + 1, right, k - (pos - left + 1));
        }
        else {
            return findK(nums, left, pos - 1, k);
        }
    }
    
    public int partition(int[] nums, int left, int right) {
        int key = nums[left];
        int i,j;
        i = left; j = right;
        while (left < right) {
            while (left < right && nums[right] <= key) right --;
            if (left < right && nums[right] > key) {
                nums[left] = nums[right];
                left ++;
            }
            while (left < right && nums[left] > key) left ++;
            if (left < right && nums[left] <= key) {
                nums[right] = nums[left];
                right --;
            }
        }
        nums[left] = key;
        //System.out.println(left);
        return left;
    }
}
