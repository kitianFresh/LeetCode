package linkedlist;

public class SortLinkList {
	public static void main(String[] args) {
		int[] arr = { 3, 4, 1, 2, 5, 7};
		ListNode dummy = new ListNode(-1);
		dummy.next = null;
		ListNode tail = dummy;
		for (int i = 0; i < arr.length; i++) {
			ListNode node = new ListNode(arr[i]);
			tail.next = node;
			tail = tail.next;
		}
		ListNode.printList(dummy.next);
		System.out.println();
		SortLinkList nr = new SortLinkList();

		ListNode head = nr.insertionSortList(dummy.next);
		System.out.println();
		ListNode.printList(head);
		
		ListNode node = nr.findCountdownKth(head, 3);
		System.out.println(node.val);
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// 首节点可能会动，因此添加冗余节点
		ListNode dummy = new ListNode(-1);
		dummy.next = null;
		ListNode p, next, pNode;
		pNode = head;
		while (pNode != null) {
			next = pNode.next; // pNode 前进 不要放在最后
			p = dummy;
			// 采用 p.next 和 pNode 提前比较，就不会让 p 到达 pNode 了
			while (p.next != null && p.next.val < pNode.val) {
				p = p.next;
			}

			// 将pNode插入到 p 的前一个位置
			pNode.next = p.next;
			p.next = pNode;

			pNode = next;

		}
		return dummy.next;
	}

	// O(nlgn) 给链表排序，归并或者快速排序，这里采用归并
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pNode = findMid(head);
		ListNode left;
		ListNode right;

		right = sortList(pNode.next);
		pNode.next = null;
		left = sortList(head);
		return mergeSortedLists(left, right);

	}

	public ListNode mergeSortedLists(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return headA == null ? headB : headA;
		ListNode dummy = new ListNode(-1);
		dummy.next = null;
		ListNode tail = dummy;
		ListNode bound = new ListNode(Integer.MAX_VALUE);
		// 利用 bound最大界，让代码更加compact & elegant;见算法导论
		while (headA != bound && headB != bound) {

			headA = (headA == null ? bound : headA);
			headB = (headB == null ? bound : headB);
			while (headA != null && headB != null && headA.val < headB.val) {
				tail.next = headA;
				tail = headA;
				headA = headA.next;
			}

			while (headA != null && headB != null && headA.val >= headB.val) {
				tail.next = headB;
				tail = headB;
				headB = headB.next;
			}
		}
		return dummy.next;
	}

	// two pointers without length find mid of linkedlists, fast pointer is twice as fast as slow pointer
	public ListNode findMid(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode fast, slow;
		fast = slow = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	// two pointers without length find countdown kth Node, ealry pointer is early k step than later pointer
	public ListNode findCountdownKth(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		ListNode early, later;
		early = later = head;
		int step = 1;
		while(step<k) {
			early = early.next;
			step ++;
		}
		while(early.next!=null) {
			early = early.next;
			later = later.next;
		}
		return later;
	}
	
}

