package tree;

import java.util.Deque;
import java.util.LinkedList;

public class TreeHeightWidth {
	//111. Minimum Depth of Binary Tree
	// 法一，分治法，最小深度等于含有叶子的左子树最小深度 和 含有叶子的右子树最小深度 中的较小者。
	// 分解左右O(1)，子问题左右， 合并，比较O(1) 但是对于树，我们发现最终的操作都是访问根节点，因此 时间复杂度是 O(n)
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (root.left != null) left = minDepth(root.left);
        if (root.right != null) right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }
    int deep = 0;
    int min = Integer.MAX_VALUE;
	// 法二， DFS先序遍历，同级当前叶子的深度，然后比较出最小值
    public void minDepthDFSInorder(TreeNode root) {
    	if (root == null) return ;
    	deep ++;
    	if (root.left == null && root.right == null) {
    		if (deep > min) {
    			min = deep;
    		}
    	}
    	minDepthDFSInorder(root.left);
    	minDepthDFSInorder(root.right);
    	deep --;
    }
    
	//104. Maximum Depth of Binary Tree
    // solution 1 分治
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if (root.left != null) left = maxDepth(root.left);
        if (root.right != null) right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
	// solution 2 最长深度就是树的层数，因此可以统计树的层数 BFS。如何知道到达了下一层呢？只要知道上一层什么时候 poll完即可！
    // 那么假设我们知道 n-1 层有m个元素在队列之中，只要在BFS的过程中，每出队一次记一次数，直到出队m次即可层数增加！
    // 利用数学归纳法知，根节点第一层一定是 1，然后根节点出队完毕后，就可以进入第二层。
    public int maxDepthBFS(TreeNode root) {
    	Deque<TreeNode> queue = new LinkedList<TreeNode>();
    	if (root == null) return 0;
    	queue.offer(root);
    	int size, levels = 0;
    	while (!queue.isEmpty()) {
    		size = queue.size();
    		while (size-- > 0) {
    			root = queue.poll();
    			if (root.left != null) queue.offer(root.left);
    			if (root.right != null) queue.offer(root.right);
    		}
    		levels ++;
    	}
    	return levels;
    }
    
	//110. Balanced Binary Tree
    
}
