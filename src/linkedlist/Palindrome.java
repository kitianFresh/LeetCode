package linkedlist;

public class Palindrome {
	public static void main(String[] args) {
		int[] a = {1,2,2,1};
		
		ListNode head,temp;
		ListNode dummby = new ListNode(0);
		dummby.next = null;
		temp = dummby;
		for (int i=0; i<a.length; i++) {
			ListNode node = new ListNode(a[i]);
			temp.next = node;
			temp = temp.next;
		}
		head = dummby.next;
		ListNode.printList(head);
		Palindrome p = new Palindrome();
		System.out.println(p.isPalindrome(head));
	}
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode dummby = new ListNode(0);
        dummby.next = head;
        ListNode first = dummby;
        ListNode second = dummby;
        for (;second.next!=null && second.next.next!=null;) {
            first = first.next;
            second = second.next.next;
        }
        // 奇数，first还需要再往前罗动一步到正中间
        if (second.next!=null) {
            first = first.next;
        }
        // 记录后半部分的头,以及中间位置
        ListNode secondHead = first.next;
        System.out.println(secondHead.val);
        
        first.next = null;
        ListNode pTemp;
        // 对first后面半部分的进行逆序，从而和前半部分比较
        for (second=secondHead;second!=null;) {
            pTemp = second;
            second = second.next;
            // 头插法逆序
            pTemp.next = first.next;
            first.next = pTemp;
        }
        ListNode.printList(head);
        // 比较前后两部分是否完全相同
        ListNode head1, head2;
        for (head1=head,head2=first.next;head1!=null && head2!=null;) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;

        }
        
        // 因为打乱了原来链表的顺序，因此再次进行复原
        secondHead = first.next;
        first.next = null;
        for (;second!=null;) {
            pTemp = second;
            second = second.next;
            pTemp = first.next;
            first.next = pTemp;
        }
        return true;
    }
}
