package swordoffer;

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int val) {
		this.val = val;
	}
}

public class BalancedBinaryTree {
	
	// [平衡二叉树](https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=11192&tPage=2&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	// 完全采用递归思想，遍历节点一次即可！　再求高度的时候，返回一个　UNB < 0 的数值来表示不平衡
	public boolean IsBalanced_Solution(TreeNode root) {
        return isBalanced(root) != UNB;
    }
    public final int UNB = -1;
    public int isBalanced(TreeNode root) {
        if (root == null) return 0;
        int l = isBalanced(root.left);
        int r = isBalanced(root.right);
        if (l == UNB || r == UNB || Math.abs(l-r) > 1) return UNB;
        return 1 + Math.max(l, r);
    }
    
    // 法一　利用定义，求左右子树的深度，然后看差，重复访问节点，　O(n^2) Top-Down　的思维
    public boolean isBalancedBT(TreeNode root) {
    	if (root == null) return true;
    	int l = depth(root.left);
    	int r = depth(root.right);
    	return Math.abs(l-r) <= 1 && isBalancedBT(root.left) && isBalancedBT(root.right);
    }
    public int depth(TreeNode root) {
    	if (root == null) return 0;
    	int l = depth(root.left);
    	int r = depth(root.right);
    	return 1 + Math.max(l, r);
    }
    
    // 法二　Bottom-up，　不用深度，用高度，DFS 在回溯的过程中，可以得到当前回溯节点的高度，那么当前节点的左右子树的高度同样使用递归可以求解
    static class Height {
    	int height = 0;
    }
    public boolean isBalancedBT(TreeNode root, Height h) {
    	if (root == null) return true;
    	Height left = new Height();
    	Height right = new Height();
    	if (!isBalancedBT(root.left, left)) return false;
    	if (!isBalancedBT(root.right, right)) return false;
    	h.height = Math.max(left.height, right.height) + 1;
    	return Math.abs(left.height - right.height) <= 1;
    }
    
    
}
