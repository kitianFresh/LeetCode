package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
	// 此类问题都是循环递归，遍历所有解空间，找到就根据条件添加结果，找不到就回溯到上一层递归
	// 可以根据条件不同, 采用不同的参数来控制和剪枝
	
	// 组合问题, 由于是组合，一般需要改变循环开始的位置，通过start参数来控制。这样可以防止重复
	//---------------------------------------------------------------------------------------------------------------------------//
	// [39. Combination Sum](https://leetcode.com/problems/combination-sum/description/)
	// 可以重复使用数字的组合求和问题, 且数组无重复数字
	public void backtrace(int[] candidates, int remain, int start, List<List<Integer>> paths, List<Integer> path) {
        int n = candidates.length;
        if (remain < 0) return;
        if (remain == 0) {
            paths.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i < n; i ++) {
            path.add(candidates[i]);
            backtrace(candidates, remain-candidates[i], i, paths, path);
            path.remove(path.size()-1);
        }
    }
	
	// [40. Combination Sum II](https://leetcode.com/problems/combination-sum-ii/description/)
	// 组合求和问题，不能重复使用不同位置上的数（必须要排序，同一层相同就可以剪枝了）
	public void dfs (int[] candidates, int remain, List<List<Integer>> paths, List<Integer> path, int start) {
        int n = candidates.length;
        if (remain < 0) return;
        if (remain == 0) {
            paths.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i < n; i ++) {
            if (i > start && candidates[i] == candidates[i-1]) continue;
            // visited[i] = true;
            path.add(candidates[i]);
            dfs(candidates, remain-candidates[i], paths, path, i+1);
            path.remove(path.size()-1);
            // visited[i] = false;
        }
        return;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        int n = candidates.length;
        // boolean[] visited = new boolean[n];
        // for (int i = 0; i < n; i ++) visited[i] = false;
        Arrays.sort(candidates);
        dfs(candidates, target, paths, path, 0);
        return paths;
    }
    
    // [216. Combination Sum III](https://leetcode.com/problems/combination-sum-iii/description/)
    // 只是40 的一个特例， 更改返回条件
    public void backtrace(int[] arr, int remain, int start, int k, List<List<Integer>> paths, List<Integer> path) {
        int n = arr.length;
        if (remain < 0) return;
        if (remain == 0) {
            if (path.size() == k) {
                paths.add(new ArrayList<Integer>(path));
            }
            return;
        }
        for (int i = start; i < n; i ++) {
            path.add(arr[i]);
            backtrace(arr, remain - arr[i], i+1, k, paths, path);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = new int[9];
        for (int i = 0; i < 9; i ++) {
            arr[i] = i + 1;
        }
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        backtrace(arr, n, 0, k, paths, path);
        return paths;
    }
    
    
    // [77. Combinations](https://leetcode.com/problems/combinations/description/#)
    // 求组合 C(n, k)
    public void backtrace(int n, int start, int k, List<List<Integer>> paths, List<Integer> path) {
        if (path.size() == k) {
            paths.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i <= n; i ++) {
            path.add(i);
            backtrace(n, i+1, k, paths, path);
            path.remove(path.size()-1);
        }
    }
    
    // [377. Combination Sum IV](https://leetcode.com/problems/combination-sum-iv/description/)
    
    
}
