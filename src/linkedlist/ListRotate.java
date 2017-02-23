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
		
		ListRotate s = new ListRotate();
		ListNode.printList(head);
		ListNode.printList(s.reverseKGroup1(head, 3));
		
	}
	public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dumby = new ListNode(0);
        dumby.next = null;
        
        ListNode dumbyHead = new ListNode(0);
        dumbyHead.next = null;
        
        ListNode pNode = head;
        // 先遍历一遍求长度
        int len = 0;
        for (;pNode != null;) {
        	len ++;
        	pNode = pNode.next;
        }
        ListNode.printList(head);
        pNode = head;
        ListNode pTemp;
        for (int i=0;pNode!=null;) {
        	// 判断是否是最后一段不足 k 个, 就不需要逆序了
            if ((len-i) < k) {
                break;
            }
            pTemp = pNode;
            pTemp.next = dumby.next;
            dumby.next = pTemp;
            i ++;
            // 记住第一段节点的头，以后不再改变了
            if (i <= k && i % k == 0) {
                dumbyHead.next = dumby.next;
                ListNode.printList(dumbyHead.next);
            }
            
            // 后续的头插法需要不断的更换新的冗余头节点，即每一组的最后一个节点
            if (i > k && i % k == 0) {
                dumby = pNode;
            }
            pNode = pNode.next;        
        }     
		return dumbyHead.next;
    }
	
	public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dumby = new ListNode(0);
        dumby.next = null;
        
        ListNode node = null;
        ListNode pNode = head;
        ListNode pTemp;
        int i;
        for (i=0;pNode!=null;) {
            pTemp = pNode;
            pNode = pNode.next;
            pTemp.next = dumby.next;
            dumby.next = pTemp;
            i ++;
            
            if (i % k == 0) {
                node = reverseKGroup(pNode, k);
                break;
            }
        }
        // 如果 i 是 小于 k 的， 说明这一部分不应该逆序，再逆序回去
        if (i < k) {
        	// pNode = head; // 严重错误的写法，此时的head 是以前 所指向的 head， 现在他已经在尾部了，现在的头部是 dumby.next;
        	pNode = dumby.next;
        	dumby.next = null;
            for (;pNode != null;) {
            	 pTemp = pNode;
                 pNode = pNode.next; // 先走，不然会被修改
                 pTemp.next = dumby.next;
                 dumby.next = pTemp;
            }
            return dumby.next;
        }
        // 尾巴指向 后面 reverseKGroup 返回的结果
        head.next = node; 
        return dumby.next;
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