package tree;

import java.util.LinkedList;
import java.util.List;

import com.sun.prism.impl.QueuedPixelSource;

public class InvertBinaryTree {
	// DFS, Recursive. 递归并不是效率不高，而是当压栈太深的时候会出现栈溢出的现象，使得程序不够健壮，执行时间和非递归其实不相上下！
	// 因此递归写法要想办法防止重复递归，这样执行时间就是快的，如斐波那契数列，可以使用动态编程记录已经算过的数而不用再次递归。
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
    
    public void swapChild(TreeNode root) {
    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    }
    
    // BFS
    public TreeNode invertTreeBFS(TreeNode root) {
    	if (root == null) return root;
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	TreeNode node;
    	while (!queue.isEmpty()) {
    		node = queue.poll();
    		swapChild(node);
    		if (node.left != null) queue.offer(node.left);
    		if (node.right != null) queue.offer(node.right);
    	}
    	return root;
    }
}
