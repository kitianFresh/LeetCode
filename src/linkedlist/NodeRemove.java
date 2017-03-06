package linkedlist;

public class NodeRemove {
	public static void main(String[] args) {
		int[] arr = { 3, 4, 1 };
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
		NodeRemove nr = new NodeRemove();

		ListNode head = nr.insertionSortList(dummy.next);
		System.out.println();
		ListNode.printList(head);
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode early, later;
		later = early = dummy;
		int step = 0;
		while (step != n) {
			early = early.next;
			step++;
		}

		while (early != null && early.next != null) {
			early = early.next;
			later = later.next;
		}
		later.next = later.next.next; // java 不用显式释放内存
		return dummy.next;
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
}
