package swordoffer;

import java.util.ArrayList;

public class TreeRootPath {
	// [二叉树中和为某一值的路径](https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        findPaths(res, path, root, target);
        return res;
    }
    public void findPaths(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, TreeNode root, int target) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                paths.add(new ArrayList<Integer>(path));
            }
            path.remove(path.size()-1);
            return;
        }
        findPaths(paths, path, root.left, target - root.val);
        findPaths(paths, path, root.right, target - root.val);
        path.remove(path.size()-1);
    }
}
