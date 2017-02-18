package linkedlist;

public class ListRotate {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode temp = head;
		for (int i=2; i<=5; i++) {
			ListNode node = new ListNode(i);
			temp.next = node;
			temp = temp.next;
		}
		ListNode pNode = head;
		for (;pNode!=null;) {
			System.out.print(pNode.val + " ");
			pNode = pNode.next;
		}
		ListRotate s = new ListRotate();
		s.printList(s.rotateRight1(head, 2));
		
	}
	public void printList(ListNode head) {
		ListNode pNode = head;
		for (;pNode!=null;) {
			System.out.print(pNode.val + " ");
			pNode = pNode.next;
		}
	}
    public ListNode rotateRight(ListNode head, int k) {
        if (k < 0) {
            throw new IllegalArgumentException();
        }
        if (k == 0 || head == null) {
            return head;
        }
        int len = 0;
        ListNode pNode = head;
        ListNode pTail = null;
        for (;pNode!=null;) {
            len ++;
            //记录尾节点
            if (pNode.next == null) {
                pTail = pNode;
                break;
            }
            pNode = pNode.next;
        }
        //防止k大于链表总长度
        k = k % len;
        if (k == 0) {
        	return head;
        }
        // 尾节点直接指向头节点
        pTail.next = head;
        
        int step = 1;
        for (pNode=head;step<len-k;step++) {
            pNode = pNode.next;
        }
        head = pNode.next;
        pNode.next = null;
        return head;
    }
    // 双指针法，时间差，这个版本虽然不用求链表长度，但是对k是有要求的，如果 k >> len, 那么反而会很慢；除非 k < len, 那么会更加高效；
    public ListNode rotateRight1(ListNode head, int k) {
    	if (k < 0) {
    		throw new IllegalArgumentException();
    	}
    	if (head == null || k == 0 || head.next == null) {
    		return head;
    	}
    	
    	ListNode dummby = new ListNode(0);
    	dummby.next = head;
    	ListNode slow = dummby;
    	ListNode fast = dummby;
    	
    	int i;
    	for (i=1;i<=k;i++) {
    		fast = fast.next;
    	}
    	for (;fast.next!=null;) {
    		slow = slow.next;
    		fast = fast.next;
    		//System.out.print(low.val + " ");
    	}
    	fast.next = head;
    	head = slow.next;
    	slow.next = null;
    	
    	
		return head;
    	
    }
}