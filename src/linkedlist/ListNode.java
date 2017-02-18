package linkedlist;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {this.val = val; next = null;}
	public static void printList(ListNode head) {
		for (;head != null;) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}
