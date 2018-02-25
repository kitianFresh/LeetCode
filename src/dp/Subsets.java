package dp;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
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
}
