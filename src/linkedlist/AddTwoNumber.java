package linkedlist;

public class AddTwoNumber {
	//第一版代码比较丑陋，考虑问题收到了合并链表的影响，在遇到任意一个链表走完时就跳出了循环，然后再连接上较长的链表继续循环，但此时检查条件过多，而且代码不美观；其实可以把后续的链表遍历过程继续放到原来的大循环中；因为后续连接过程中用到的是同样的进位相加过程；
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) return l1==null?l2:l1;
        ListNode dummby = new ListNode(0);
        dummby.next = null;
        ListNode tail = dummby;
        int carry = 0, sum =0;
        for (;l1!=null || l2!=null;) {
            sum = (l1==null?0:l1.val) + (l2==null?0:l2.val) + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            tail.next = node;
            tail = tail.next;
            l1 = (l1==null?null:l1.next);
            l2 = (l2==null?null:l2.next);
        }
        if (carry == 1) {
            tail.next = new ListNode(1);
        }
        return dummby.next;
	}
	
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1==null?l2:l1;
        ListNode dummby = new ListNode(0);
        dummby.next = null;
        ListNode tail = dummby;
        int carry = 0, sum =0;
        for (;l1!=null&&l2!=null;) {
            sum = l1.val + l2.val + carry;
            ListNode node = new ListNode(sum>=10?(sum-10):sum);
            tail.next = node;
            tail = tail.next;
            carry = sum>=10?1:0;
            l1 = l1.next;
            l2 = l2.next;
            
        }
        if (l1 != null) {
            for (;l1!=null;) {
                sum = l1.val + carry;
                if (sum < 10) {
                    l1.val += carry;
                    tail.next = l1;
                    carry = 0;
                    break;
                }
                
                carry = 1;
                l1.val = sum - 10;
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }
        }
        if (l2 != null) {
            for (;l2!=null;) {
                sum = l2.val + carry;
                if (sum < 10) {
                    l2.val += carry;
                    tail.next = l2;
                    carry = 0;
                    break;
                }
                
                carry = 1;
                l2.val = sum - 10;
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            tail.next = new ListNode(carry);
            tail.next.next = null;
        }   
        return dummby.next;
    }
}
