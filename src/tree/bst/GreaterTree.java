package tree.bst;

import java.util.Stack;

import tree.TreeNode;

public class GreaterTree {
	private int prefixSum = 0;
	
	// 由于逆中序遍历BST会得到降序排列，因此遍历过程中即可记下 前缀和，访问当前节点时候即可加和所有大于当前节点的总和！！
	public void inverseInOrder(TreeNode root) {
		if (root == null)
			return;
		inverseInOrder(root.right);
		root.val += prefixSum;
		prefixSum = root.val;
		inverseInOrder(root.left);
	}

	public TreeNode convertBST(TreeNode root) {
		inverseInOrder(root);
		return root;
	}
	
	
	// 直接逆中序遍历，递归
	public TreeNode convertBSTDFS(TreeNode root) {
        if (root == null) return root;
        convertBSTDFS(root.right);
        root.val += prefixSum;
        prefixSum = root.val;
        convertBSTDFS(root.left);
        return root;
    }
	
	// stack
	
	public TreeNode convertBSTStack(TreeNode root) {
		if (root == null) return null;
		int prefixSum = 0;
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (node != null || !stack.isEmpty()) {
			if (node!=null) {
			    stack.push(node);
				node = node.right;
			}
			else {
				node = stack.pop();
				node.val += prefixSum;
				prefixSum = node.val;
				node = node.left;
			}
		}
		return root;
	}
}
