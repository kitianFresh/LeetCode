package swordoffer;

public class KthListNode {
	
	// [链表中倒数第k个节点](https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) return null;
        ListNode dumby = new ListNode(0);
        dumby.next = head;
        ListNode early = dumby;
        ListNode later = dumby;
        int count = 0;
        while (early != null && count < k) {
            early = early.next;
            count ++;
        }
        if (early == null) return null;
        while (early!=null) {
            early = early.next;
            later = later.next;
        }
        return later;
    }
}
