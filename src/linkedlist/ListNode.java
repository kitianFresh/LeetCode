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
	
	public static ListNode constructTailStyleByArray(int[] arr) {
		
		if (arr == null || arr.length == 0) return null;
		ListNode dummy = new ListNode(1);
		ListNode tail = dummy;
		for (int i=0; i<arr.length; i++) {
			ListNode node = new ListNode(arr[i]);
			tail.next = node;
			tail = tail.next;
		}
		return dummy.next;
		
	}
}
