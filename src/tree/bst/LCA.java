package tree.bst;

import tree.TreeNode;

public class LCA {
	
	// 分治思想，要么是根，要么在左子树，要么在右子树，如果为根，则 满足 左子问题返回null且右子问题返回null，且当前root=null或者pq之一和root想等，则返回root。
	// 最后，只可能是左右子问题之一会找到ancestor; left返回的就是对左子问题的查询，right返回的就是对右子问题的查询，为null说明没有；
	// 非空说明有，如果左右都非空说明当前root就是ancestor
	public TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestorBT(root.left, p, q);
        TreeNode right = lowestCommonAncestorBT(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
	
	public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val)*(root.val - q.val) > 0) { // 同左或同右
        	root = root.val>p.val?root.left:root.right;
        }
        return root;
    }	
	
	public TreeNode lowestCommonAncestorBST1(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val - p.val)*(root.val - q.val) > 0) { // 同左或同右
        	return lowestCommonAncestorBST1(root.val>p.val?root.left:root.right, p, q);
        }
        return root;
    }	
	
	// 低级版本可以证明，最近公共祖先要么是 p q之一，要么 p q 一定是分布在ancestor的左子树和右子树上;
	// 反证法：如果pq在ancestor的同一个子树上，例如ancestor.left,那么必定可以找到ancestor.left 是比ancestor更近的祖先，因此是祖先，那么 pq一定位于其左右子树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null) {
            if (root == p || root == q) return root;
            if (findNodeInBST(root.left, p) && findNodeInBST(root.left, q)) {
                root = root.left;
            }
            else if (findNodeInBST(root.right, p) && findNodeInBST(root.right, q)) {
                root = root.right;
            }
            else {
                return root;
            }
        }
        return root;
    }	
	
	public boolean findNodeInBST(TreeNode root, TreeNode p) {
        if (root == null || p == null) return false;
        
        if (root == p) {
            return true;
        }
        return findNodeInBST(root.left, p) || findNodeInBST(root.right, p);
    }
    

}
