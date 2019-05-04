package tree;

import java.util.Deque;
import java.util.LinkedList;

public class SymmetricTree {
	
	public boolean sameTree(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) return true;
		if (node1 == null && node2 != null || node1 != null && node2 == null) return false;
		return node1.val == node2.val && sameTree(node1.left, node2.left) && sameTree(node1.right, node2.right);
	}
	
	//DFS 递归 O(n)
	public boolean mirrorTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null && node2 != null || node1 != null && node2 == null) return false;
        return node1.val == node2.val && mirrorTree(node1.left, node2.right) && mirrorTree(node1.right, node2.left);
    }
    public boolean isSymmetric(TreeNode root) {
       if (root == null || root.left == null && root.right == null) return true;
       return mirrorTree(root.left, root.right);
    }
    
    // BFS 调整进入队列的顺序，可以实现队列出队顺序的改变，可以每次选出对称的两个元素
    public boolean isSymmetricBFS(TreeNode root) {
    	if (root == null || root.left == null && root.right == null) return true;
    	if (root.left == null && root.right != null || root.left != null && root.right == null) return false;
    	Deque<TreeNode> queue = new LinkedList<TreeNode>();
    	int size;
    	queue.offer(root.left);
    	queue.offer(root.right);
    	TreeNode p,q;
    	while (!queue.isEmpty()) {
    		size = queue.size();
    		while (size > 0) { // 需要控制一层进入完之后，因为同层的比较是对称比较的，因此同一层次的进队列顺序也发生了调整！
    			// 出来的两个刚好是上次的两端的！实现了在队列中直接取出回文串儿的两端！！！
    			p = queue.poll();
    			q = queue.poll();
    			if (p == null || q == null) return false;
    			if (p.val != q.val) return false;
    			// 这里与一般的BFS相比，进队列的顺序发生了变化，让最左和最右先进队，然后是次级进队列，由于一次出来两个，因此一次必须同时进队列四个！
    			if (p.left != null && q.right != null) {
    			    queue.offer(p.left);// p.left.val == q.right.val
    			    queue.offer(q.right);
    			}
    			if (p.left != null && q.right == null || p.left == null && q.right != null) return false;
    			
    			if (p.right != null && q.left != null) {
    			    queue.offer(p.right); // p.right.val = q.left.val
    			    queue.offer(q.left);
    			}
    		    
    		    if (p.right != null && q.left == null || p.right == null && q.left != null) return false;
    			size -= 2;
    		}
    	}
    	return true;
    }
}
