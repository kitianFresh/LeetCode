package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelTraverse {
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> paths = new LinkedList<List<Integer>>();
        if (root == null) return paths;
        
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            LinkedList<Integer> path = new LinkedList<Integer>();
            while (size-- >= 0) {
                root = queue.poll();
                path.add(root.val);
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            paths.addFirst(path);
        }
        return paths;
    }
}
