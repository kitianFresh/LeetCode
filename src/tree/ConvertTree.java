package tree;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
		next = null;
	}
}

public class ConvertTree {
	
	public TreeNode toBST(int[] nums, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(nums[l]);
        int mid = (l+r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums, l, mid-1);
        root.right = toBST(nums, mid+1, r);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return toBST(nums, 0, nums.length-1);
    }
    
    // 由于这里是二分法建树，不是二分法查找，需要遍历所有的分支，必须记住数组的左右边界才能确定分支！！因此需要使用两个显式栈来保存左右边界！
    public TreeNode sortedArrayToBSTStack(int[] nums) {
    	if (nums == null || nums.length < 1) return null;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
    	Stack<Integer> leftStack = new Stack<Integer>(); // 存储每一层的所有左边界
    	Stack<Integer> rightStack = new Stack<Integer>(); // 存储每一层的所有右边界
    	int left, right, mid;
    	left = 0; right = nums.length - 1;
    	leftStack.push(left);
    	rightStack.push(right);
    	TreeNode root = new TreeNode(0);
    	nodeStack.push(root);
    	TreeNode node;
    	while (!nodeStack.isEmpty()) { // 还是先序遍历的stack写法，不过加入了其他信息，首先存入根节点，以及左右边界！
    									//然后每一次出栈后，给节点赋值，并添加下一层信息中左右子树的边界
    		node = nodeStack.pop();
    		left = leftStack.pop();
    		right = rightStack.pop();
    		mid = (left + right)/2;
    		node.val = nums[mid];
    		if (mid+1 <= right) { // 构建右子树
	    		leftStack.push(mid+1);// 右子树先进栈
	    		rightStack.push(right); // 左子树
	    		node.right = new TreeNode(0);
	    		nodeStack.push(node.right);
    		}
    		if (mid-1 >= left) { // 构建左子树
    			leftStack.push(left); // 
    			rightStack.push(mid-1);
    			node.left = new TreeNode(0);
    			nodeStack.push(node.left);
    		}
    	}
    	return root;
    }
    
    public TreeNode sortedArrayToBSTStack1(int[] nums) {
    	if (nums == null || nums.length < 1) return null;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<List<Integer>> boundStack = new Stack<List<Integer>>();
    	int left, right, mid;
    	left = 0; right = nums.length - 1;
    	boundStack.push(Arrays.asList(left, right));
    	TreeNode root = new TreeNode(0);
    	nodeStack.push(root);
    	TreeNode node;
    	while (!nodeStack.isEmpty()) { // 还是先序遍历的stack写法，不过加入了其他信息，首先存入根节点，以及左右边界！
    									//然后每一次出栈后，给节点赋值，并添加下一层信息中左右子树的边界
    		node = nodeStack.pop();
    		left = boundStack.peek().get(0);
    		right = boundStack.peek().get(1);
    		boundStack.pop();
    		mid = (left + right)/2;
    		node.val = nums[mid];
    		if (mid+1 <= right) { // 构建右子树
	    		// 右子树先进栈
	    		boundStack.push(Arrays.asList(mid+1, right));
	    		node.right = new TreeNode(0);
	    		nodeStack.push(node.right);
    		}
    		if (mid-1 >= left) { // 构建左子树
    			boundStack.push(Arrays.asList(left, mid-1));
    			node.left = new TreeNode(0);
    			nodeStack.push(node.left);
    		}
    	}
    	return root;
    }
    
    // sorted list to BST
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return toBST(head, tail);
    }
    public TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail) return new TreeNode(head.val);
        if (head.next == tail) {
            TreeNode root = new TreeNode(head.val);
            root.right = new TreeNode(tail.val);
            return root;
        }
        ListNode pre, fast, slow;
        pre = fast = slow = head;
        while (fast!=tail && fast.next!=tail) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, pre);
        root.right = toBST(slow.next, tail);
        return root;
    }
    
}
