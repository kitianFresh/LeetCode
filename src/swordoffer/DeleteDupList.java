package swordoffer;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class DeleteDupList {
	
	// [**删除链表中的重复结点**](https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=3&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)
	public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode dumby = new ListNode(0);;
        dumby.next = null;
        ListNode tail = dumby;
        ListNode cur = pHead;
        while (cur!=null && cur.next!=null) {
            if (cur.val == cur.next.val) {
                while (cur != null && cur.next != null && cur.val == cur.next.val) cur = cur.next;
                cur = cur.next;
            }
            else {
                tail.next = cur;
                tail = cur;
                cur = cur.next;
                tail.next = null;
            }
        }
        if (cur != null) {
            tail.next = cur;
            tail = cur;
            tail.next = null;
        }
        return dumby.next;
    }
}
