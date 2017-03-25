package tree;

import java.util.Deque;
import java.util.LinkedList;

public class PopulatingNextPointer {
	//116. Populating Next Right Pointers in Each Node
	// 这里我们发现，如果上一层链接好了，那么其实下一层次的遍历根本就不需要使用队列来存储，因为他们的已经被链接起来了，队列存储就是因为不知道下一层次的顺序，所以才提前让他们按照父亲被访问的顺序入队，但是这里的上一层父亲被链表连接起来了，顺序是确定可以访问的，因此不再需要多于的存储
    // Time Complexity O(n); Space Complexity O(1)
    public void connectO1(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode prev = null;
        TreeLinkNode curr = root;
        while (curr.left != null) {
            // 保存该层的最左边的节点，用于进入下一层
            prev = curr;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            curr = prev.left; // 进入下一层
        }
    }
	
	
    //117. Populating Next Right Pointers in Each Node II
	// 通用的解法，使用队列对每一层进行遍历即可，这里可以使用链表的冗余结点法，方便写代码
	// 但此种解法的空间复杂度是　O(width),现在需要找出O(1)空间复杂度的解法，时间复杂度Ｏ(n)
	public void connect(TreeLinkNode root) {
        if (root == null) return;
        Deque<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        int size = 0;
        TreeLinkNode dummy = new TreeLinkNode(-1);
        dummy.left = dummy.next = null;
        dummy.right = root;
        TreeLinkNode tail = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            tail = dummy;   // 为下一层链接做准备
            size = queue.size();
            while (size-- > 0) {
                root = queue.poll();
                tail.next = root;
                tail = root;
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            tail.next = null;// 每一层的链尾部置空
        }
        
    }
	
	// 其实就是层次遍历的链表版本！！！左右链接起来其实就是孩子进队的过程
    public void connectOpt1(TreeLinkNode root) {
       if (root == null) return;
       TreeLinkNode dummy = new TreeLinkNode(-1); // 冗余链表尾节点
       
       TreeLinkNode tail = null;
       boolean flag = true;
       while (root != null) {
           dummy.next = dummy.left = dummy.right = null;
           tail = dummy;
           while (root != null) {
               if (root.left != null) {tail.next = root.left; tail = root.left;}
               if (root.right != null) {tail.next = root.right; tail = root.right;}
               root = root.next;
           }
           root = dummy.next;
       }
    }
}
