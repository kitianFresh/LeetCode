package tree.bst;

import java.util.Stack;

import tree.TreeNode;

class CountTreeNode {
	int val;
	int count;
	CountTreeNode left,right;
	CountTreeNode(int val, int count) {
		this.val = val;
		this.count  = count;
		this.left = this.right = null;
	}
}


public class ksthSmallest {
	
	public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    public int kthSmallestDFS(TreeNode root, int k) {
        int left = countNodes(root.left);
        if (k == left + 1) {
            return root.val;
        }
        else if (k < left + 1) {
            return kthSmallest(root.left, k);
        }
        else {
            return kthSmallest(root.right, k-left-1);   
        }
    }
	
	// 二叉查找树的中序遍历是有序的！Iteratively InOrder traversal, remember three stack traversals use just one outer loop.
	public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                if (--k == 0) return root.val;
                root = root.right;
            }
        }
        return 0;
    }
}
