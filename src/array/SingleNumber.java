package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SingleNumber {
	
	
	
	// [136. Single Number](https://leetcode.com/problems/single-number/#/description)
	// Given an array of integers, every element appears twice except for one. Find that single one.
	public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }
	
	// [137. Single Number II](https://leetcode.com/problems/single-number-ii/#/solutions)
	public int singleNumberII(int[] nums) {
		int n = nums.length;
		int ans = 0;
		int sum = 0;
		for (int i = 0; i < 32; i++) {
		    sum = 0;
			for (int j = 0; j < n; j++) {
				if (((nums[j] >> i) & 1) == 1) {
					sum += 1;
					sum %= 3;
				}
			}
			if (sum != 0) {
				ans |= sum << i;
			}
		}
		return ans;
	}
	
	// 改进, one 表示对应bit位上出现了 一次1 的状态, two表示对应 bit 位出现了 二次 1 的状态, 
	//three 表示对应bit位出现 三次 1 的状态(此时就应该将one 和 two 对应三次1的位置置0, 因为三次的都是三个数的)
	// three, 就是记录那些出现了三次的bit位,并将其置1,用来表示某一个数出现了三次了. 他可以通过 two & nums[i] 得到;
	// two, 就是记录那些 出现了 二次的bit位, 并将其置1, 用来表示某一个数出现二次了. 他可以通过 two |= (one & nums[i])
	// 为什么是 two = two | (one & nums[i]) 因为 two 中某些位置可能已经出现两次1了, 新来的数在这些位置不一定出现两次;
	public int singleNumberII1(int[] nums) {
		int one = 0, two= 0, three = 0;
		for (int i = 0; i < nums.length; i++) {
			three = nums[i] & two;
			two |= (one & nums[i]);// two 中某些位置可能已经出现两次1了
			
			one ^= nums[i];// 上一次出现1次1, 这次再出现就不是一次了,而是二次, 因此置0, 如果上一次没出现1, 这次nums[i]中对应bit为1,则置1, 因此为 异或操作
			// 清除已经出现过三次1的bit位置, 他们都是重复三次的数贡献的部分;
			one &= ~three;
			two &= ~three;
		}
		return one | two;// 剩余重复一次或者二次的就是那个数了,因此 或运算;
	}
	
	// [260. Single Number III](https://leetcode.com/problems/single-number-iii/#/description)
	public int[] singleNumberIII(int[] nums) {
		int[] ans = new int[2];
        int diff = 0;
        for (int num:nums) {
            diff ^= num;
        }
        diff &= ~(diff-1);// 取出一个两个数数相异的bit位, 这里选出左右边一个1. 因为 diff 是通过 ^ 得到的, 因此 bit 为 1 的位置必定是两个数相异的位置
        int k;
        for (int num: nums) {
            if ((k=num&diff) != 0) { // 根据相异的位置对所有的数据分组, 其实是为了把这两个相异的数分开
                ans[0] ^= num;
            }
            else {
                ans[1] ^= num;
            }
        }
        return ans;
	}
	
	// [268. Missing Number](https://leetcode.com/problems/missing-number/#/description)
	//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
	// For example,
	// Given nums = [0, 1, 3] return 2.
	public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
	
	// [389. Find the Difference](https://leetcode.com/problems/find-the-difference/#/description)
	
	/**
	 * Given two strings s and t which consist of only lowercase letters.
		String t is generated by random shuffling string s and then add one more letter at a random position.
		Find the letter that was added in t.
		
		Example:
		Input:
		s = "abcd"
		t = "abcde"
		Output:
		e
	 */
	public char findTheDifference(String s, String t) {
        char ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            ans ^= t.charAt(i);
        }
        return ans;
    }
	
	// [349. Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/#/description)
	// 法一 two pointer and Sorted; time O(nlgn) space O(1)
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> interset = new ArrayList<Integer>();
        int i = 0, j = 0;
        int m = nums1.length;
        int n = nums2.length;
        while (i < m && j < n) {
            while (i < m - 1 && nums1[i] == nums1[i+1]) i++;// 去重
            while (j < n - 1 && nums2[j] == nums2[j+1]) j++;
            if (nums1[i] < nums2[j]) {
                i ++;
            }
            else if (nums1[i] > nums2[j]) {
                j ++;
            }
            else {
                interset.add(nums1[i]);
                i ++;
                j ++;
            }
        }
        int[] res = new int[interset.size()];
        for (i = 0; i < res.length; i++) {
            res[i] = interset.get(i);
        }
        return res;
    }
    // 法二 hashtable time O(n) space o(n)
    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> interset = new HashSet<Integer>();
        for (int num : nums1) {
            set.add(num);
        }
        
        for (int num : nums2) {
            if (set.contains(num)) {
                interset.add(num);
            }
        }
        
        int[] res = new int[interset.size()];
        int index = 0;
        for (Integer i : interset) {
        	res[index++] = i;
        }
        return res;
    }
	
    // [350. Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/#/description)
    public int[] intersectII(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> interset = new ArrayList<Integer>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums2) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) map.remove(num);
                interset.add(num);
            }
        }
        int[] res = new int[interset.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = interset.get(i);
        }
        return res;
    }
    
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
    
    //　[448. Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/#/solutions)
    // Time O(n) Space O(n)
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return res;
        int n = nums.length;
        boolean[] map = new boolean[n];
        for (int i = 0; i < n; i++) {
        	map[i] = false;
        }
       
        for (int num : nums) {
            map[num-1] = true;
        }
        
        for (int i = 0; i < n; i++) {
            if (!map[i]) {
                res.add(i+1);
            }
        }
        return res;
    }
    // Time O(n) Space O(1) 现将nums中所有元素按照hash 变为负数，那些没有出现的数对应位置的元素将保持正数
    public List<Integer> findDisappearedNumbers1(int[] nums) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return res;
        
        int n = nums.length;
        int num;
        for (int i = 0; i < n; i++) {
        	num = Math.abs(nums[i]) - 1;
        	if (nums[num] > 0) {
        		nums[num] = -nums[num];
        	}
        }
       
        for (int i = 0; i < n; i++) {
        	if (nums[i] > 0) {
        		res.add(i+1);
        	}
        }
 
        return res;
    }
    // [442. Find All Duplicates in an Array](https://leetcode.com/problems/find-all-duplicates-in-an-array/#/description)
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return res;
        int n = nums.length;
        int val;
        for (int i = 0; i < n; i++) {
            val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
            else {
                res.add(Math.abs(nums[i]));
            }
        }
        return res;
    }
    
    // [217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/#/description)
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            else set.add(num);
        }
        return false;
    }
    
    // [219. Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/#/description)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0;i < n; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i])-i) <= k) return true;
            }
            map.put(nums[i], i);//　当前不含，或者已经含有但是间距太大都进行更新．因为 i 是顺序递增的．
        }
        return false;
    }
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
    }
    
}