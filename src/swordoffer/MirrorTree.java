package swordoffer;

public class MirrorTree {
	// [二叉树的镜像](https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	public void Mirror(TreeNode root) {
        if (root == null) return;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        return;
    }
	
	
	boolean isSymmetrical(TreeNode root)
    {
        if (root == null) return true;
        return symmetric(root.left, root.right);
    }
    
    public boolean symmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null && root2 != null) return false;
        if (root1 != null && root2 == null) return false;
        return root1.val == root2.val && symmetric(root1.left, root2.right) && symmetric(root1.right, root2.left);
    }
}
