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
}
