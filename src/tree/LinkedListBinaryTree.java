package tree;

import java.util.Stack;

public class LinkedListBinaryTree {
	public void flatten(TreeNode root) {
        if (root == null) return ;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (prev == null) {
                prev = root;
            }
            else {
                prev.left = null;
                prev.right = root;
                prev = root;
            }
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
    }
}
