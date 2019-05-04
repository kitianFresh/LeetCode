package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
	TreeNode root;
	BinaryTree(TreeNode key) {
		root = key;
	}
	BinaryTree() {
		root = null;
	}
	public TreeNode buildBTreeByPerfectArray(List<Integer> list, int i) {
		if (i >= list.size()) return null;
		if (list.get(i) == null) return null;
		TreeNode root = new TreeNode(list.get(i));
		root.left = buildBTreeByPerfectArray(list, 2*i+1);
		root.right = buildBTreeByPerfectArray(list, 2*i+2);
		return root;
	}
	public int findIndex(int[] a, int s, int e, int key) {
        for (int i=s; i<=e; i++) {
            if (key == a[i]) return i;
        }
        return -1;
    }
    // 分治法根据先序遍历首元素为根，而中序遍历根能够把左右子树分开，可以分解为 左子树和 右子树 的建立的子问题！
    public TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int mid = findIndex(inorder, is, ie, preorder[ps]);
        root.left = build(preorder, ps+1, ps+mid-is, inorder, is, mid-1);
        root.right = build(preorder, ps+mid-is+1, pe, inorder, mid+1, ie);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
	// 先序 中序 后序遍历都是深度优先，递归压栈，适合寻找元素为叶节点的场景。栈的深度最深不超过树高！
	public void preOrder(TreeNode root, List<Integer> order) {
		if (root == null) return;
		order.add(root.val);
		preOrder(root.left, order);
		preOrder(root.right, order);
	}
	
	public void inOrder(TreeNode root, List<Integer> order) {
		if (root == null) return;
		inOrder(root.left, order);
		order.add(root.val);
		inOrder(root.right, order);
	}
	
	public void postOrder(TreeNode root, List<Integer> order) {
		if (root == null) return;
		postOrder(root.left, order);
		postOrder(root.right, order);
		order.add(root.val);
	}
	
	
	// 先序中序后序遍历的非递归算法
	public List<Integer> preOrderStack(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> order = new LinkedList<Integer>();
		if (root == null) return order;
		
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			order.add(root.val);
			if (root.right != null) stack.push(root.right);
			if (root.left != null) stack.push(root.left);
		}
		
		return order;
	}
	
	// 思考,左 中 右的顺序，递归中，直到达到最左端左子树为空时才开始出栈中间元素，且其后继应该是右子树，因为指针指向右子树
	public List<Integer> inOrderStack(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> order = new LinkedList<Integer>();
		if (root == null) return order;
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			}
			else {
				root = stack.pop();
				order.add(root.val);
				root = root.right;
			}
		}
		return order;
	}
	
	// PostOrder is not a tail-recursion because after self-call it still has a statement, so it is more complex to transfer it to non-recursive.
	// double stacks method! 
	// pre order        [root left right]:  10 5 3 3 -2 2 1 -3 11 
	// pre inverse order[root right left]:  10 -3 11 5 2 1 3 -2 3 stack
	// post order       [left right root]: 	3 -2 3 1 2 5 11 -3 10 stackReverse
	// we modify preOrderStack by exchanging root.left and root.right push stack order, 
	// and use another stack to reverse it, we will get our post order. 
	public List<Integer> postOrderStack(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> stackReverse = new Stack<TreeNode>();
		List<Integer> order = new LinkedList<Integer>();
		if (root == null) return order;
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			stackReverse.push(root);
			if (root.left != null) stack.push(root.left);
			if (root.right != null) stack.push(root.right);
		}
		while (!stackReverse.isEmpty()) {
			order.add(stackReverse.pop().val);
		}
		return order;
	}
	
	public List<Integer> postOrderStack1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> order = new LinkedList<Integer>();
		if (root == null) return order;
		TreeNode prev = null;
		TreeNode curNode = root;
		stack.push(root);
		while (!stack.isEmpty()) {
			curNode = stack.peek();
			// moving down! record previous node has been visited!
			if (prev == null || prev.left == curNode || prev.right == curNode) {
				if (curNode.left != null) {
					stack.push(curNode.left);
				}
				else if (curNode.right != null) {
					stack.push(curNode.right);
				}
				else {
					order.add(curNode.val);
					stack.pop();
				}
			}
			// moving up from left child, previous node is left, so if curNode has right, push right first, then pop curNode.
			if (curNode.left == prev) {
				if (curNode.right != null) {
					stack.push(curNode.right);
				}
				else {
					order.add(curNode.val);
					stack.pop();
				}
			}
			// moving up from right child, previous node is right, so curNode pop. [left right root]
			if (curNode.right == prev) {
				order.add(curNode.val);
				stack.pop();
			}
			prev = curNode;
		}
		return order;
	}
	
	
	// 队列实现广度优先搜索，适合寻找接近根节点的元素。 队列的长度最长不会超过树的最大宽度
	public List<Integer> levelOrder(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> order = new LinkedList<Integer>();
		if (root == null) return order;
		queue.offer(root);
		while (!queue.isEmpty()) {
			root = queue.poll();
			order.add(root.val);
			if (root.left != null) queue.offer(root.left);
			if (root.right != null) queue.offer(root.right);
		}
		return order;
	}

}
