package tree;

import java.util.Deque;
import java.util.LinkedList;

public class BottomLeftLeave {
	public int findBottomLeftValue(TreeNode root) {
		
		// 513. Find Bottom Left Tree Value
		
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int size, first;
        first = root.val;
        boolean flag = true;
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size-- > 0) {
                root = queue.poll();
                if (flag == true) {
                    first = root.val;
                    flag = false;
                }
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            flag = true;
            
        }
        return first;
    }
}
