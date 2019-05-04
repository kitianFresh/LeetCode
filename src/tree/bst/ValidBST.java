package tree.bst;

import java.util.Stack;

import tree.TreeNode;

public class ValidBST {
	// 错误的版本，注意二叉树不只是左孩子小于父亲，右孩子大于父亲，左右孩子都是BST，而是左子树上的所有节点都小于父亲，右子树上的所有节点都大于父亲，左右子树也是BST
	public boolean isValidBST(TreeNode root) {
		if (root == null || root.left == null && root.right == null)
			return true;
		if (root.left == null && root.right != null) {
			return root.right.val > root.val && isValidBST(root.right);
		}
		if (root.left != null && root.right == null) {
			return root.left.val < root.val && isValidBST(root.left);
		}
		return root.left.val < root.val && root.right.val > root.val && isValidBST(root.left) && isValidBST(root.right);
	}
	
	public boolean isValidBSTInorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int prev = 0;
		boolean first = true; // 注意 test case 中如果first访问的节点是 Integer.MIN_VALUE　的话，prev 是不能设置成　 -2147483648 的
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			}
			else {
				root = stack.pop();
				if (first) {
				    prev = root.val;
				    first = false;
				}
				else {
				    if(root.val > prev) {
					    prev = root.val;
				    }
				    else {
					    return false;
				    }
				}
				root = root.right;
			}
		}
		return true;
	}
}
