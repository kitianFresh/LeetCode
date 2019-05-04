package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
	// [78. Subsets](https://leetcode.com/problems/subsets/description/)
	// [90. Subsets II contains duplicated element](https://leetcode.com/problems/subsets-ii/description/)
public class Subsets {
	
	// [78. Subsets](https://leetcode.com/problems/subsets/description/)
	// 解法一  自顶向下的递归
	public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, nums.length-1);
    }
    
    public List<List<Integer>> subsets(int[] nums, int end) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (end < 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        List<List<Integer>> res1 = subsets(nums, end - 1);
        List<List<Integer>> res2 = new ArrayList<List<Integer>>();
        for (List<Integer> l : res1) {
            ArrayList<Integer> b = new ArrayList<Integer>(l);
            b.add(nums[end]);
            res2.add(b);
        }
        for (List<Integer> l : res1) {
            res.add(l);
        }
        for (List<Integer> l : res2) {
            res.add(l);
        }
        
        return res;
        
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        if (end < 0) {
//            res.add(new ArrayList<Integer>());
//            return res;
//        }
//        List<List<Integer>> res1 = subsets(nums, end - 1);
//        res.addAll(res1);
//        int lastSize = res1.size();
//        for (int i = 0; i < lastSize; i++) {
//            List<Integer> e = new ArrayList<Integer>(res.get(i));
//            e.add(nums[end]);
//            res.add(e);
//        }
//        
//        return res;
    }
    
    
    
	// [90. Subsets II contains duplicated element](https://leetcode.com/problems/subsets-ii/description/)
    // 解法二
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>()); // 空集合
        int begin = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0 || nums[i] != nums[i-1]) begin = 0; // 当元素不相等的时候,从头开始取出所有的子集,再加上新元素,添加进来,和没有重复元素的时候一样
            // 当元素相等的时候,不能从头开始,因为从头到上一次构建开始这些都已经由上一个元素构建完了,不需要再构建了;因此直接使用该重复元素新构建的子集进行构建新子集;
            int size = res.size(); // 当前问题规模解的个数
            for (int j = begin; j < size; j ++) {
                ArrayList<Integer> sub = new ArrayList<Integer>(res.get(j));
                sub.add(nums[i]);
                res.add(sub);
            }
            begin = size;
        }
        return res;
    }
}
