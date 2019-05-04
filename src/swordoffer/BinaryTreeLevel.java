package swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevel {
	
	// [把二叉树打印成多行](https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213&tPage=3&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	public ArrayList<ArrayList<Integer>> print(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) return res;
        queue.offer(root);
        int size = 1;
        while (!queue.isEmpty()) {
            size = queue.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            while (size-- != 0) {
                root = queue.poll();
                level.add(root.val);
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            res.add(level);
        }
        return res;
	}
}
