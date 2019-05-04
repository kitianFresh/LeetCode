package linkedlist;



public class EvenOdd {
	// 328. Odd Even Linked List
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode odd,even;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        odd = oddHead; even = evenHead;
        // 因为 odd 从奇数开始，因此为了防止odd最后为空，我们让odd是最后一个元素(如果有奇数元素)时就跳出来（此时偶数一定指到了null，完善了偶链表），或者odd是倒数第二个元素(如果有偶数元素)跳出来
        // （此时偶数一定指到最后一个元素，最后一个元素已经对链表进行了闭合）
        while (odd.next!=null && odd.next.next!=null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        return oddHead;
    }
}
