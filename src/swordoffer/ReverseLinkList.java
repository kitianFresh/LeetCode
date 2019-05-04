package swordoffer;

public class ReverseLinkList {
	
	// [链表翻转](https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&tPage=1&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	public ListNode ReverseList(ListNode head) {
        ListNode dumby = new ListNode(0);
        dumby.next = null;
        ListNode temp;
        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = dumby.next;
            dumby.next = temp;
        }
        return dumby.next;
    }
}
