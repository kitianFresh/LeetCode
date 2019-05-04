import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left, right;
	public TreeNode(int val) {this.val = val;}
}

public class SearchRangeBST {
	public static List<Integer> searchRangeBST(TreeNode root, int k1, int k2) {
		if (root == null) return new ArrayList<Integer>();
		if (root.val < k1) return searchRangeBST(root.right, k1, k2);
		else if (root.val > k2) return searchRangeBST(root.left, k1, k2);
		else {
			List<Integer> lefts = searchRangeBST(root.left, k1, root.val);
			List<Integer> rights = searchRangeBST(root.right, root.val, k2);
			List<Integer> roots = new ArrayList<Integer>();
			roots.add(root.val);
			List<Integer> res = new ArrayList<Integer>();
			res.addAll(lefts);
			res.addAll(roots);
			res.addAll(rights);
			return res;
		}
	}
}
