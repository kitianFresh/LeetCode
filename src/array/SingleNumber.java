package array;

public class SingleNumber {
	// [287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/#/solutions)
    // binary search 的理解! 我们一般认为的 二分查找是对数组位置的二分,默认数组有序! 但是如果数组无序, 那么有没有办法做二分查找呢? 
    // 这里的二分查找就非常巧妙, 我们二分树的节点值就是我们要找的数本身,而原来的数组的位置和这棵树并没有直接的对应关系, 关键条件就是这 n+1 个数都是 1~n.
    // 即如果是 n 个数,分别是 1~n各不相同的话,那么我们以 mid = (n+1)/2 为中点, 那么小于 mid 的数的数目count一定是 mid个!如果有 重复的数,
    // 若重复的数的值小于mid, count必定大于mid, 即重复的数在 mid 左边, 若重复的数的值大于mid. count必定小于等于mid,即重复的数在 mid 的右边!
	// O(nlgn) 另一种 O(n) 写法 http://keithschwarz.com/interesting/code/?dir=find-duplicate
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int n = nums.length;
        int low = 1;
        int high = n - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (countLE(nums, mid) <= mid) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
    
    public static int countLE(int[] a, int num) {
        int count = 0;
        for (int i : a) {
            if (i <= num) {
                count ++;
            }
        }
        return count;
    }
}
