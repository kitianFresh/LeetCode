package linkedlist;

public class ReorderList {
	public static void main(String[] args) {
		
		int[] a = {1,2,3};
		ListNode head = new ListNode(1);
		ListNode temp = head;
		for (int i=2; i<=1; i++) {
			ListNode node = new ListNode(i);
			temp.next = node;
			temp = temp.next;
		}
		ListNode pNode = head;
		ListNode.printList(head);
		ReorderList r = new ReorderList();
		r.reorderList1(head);
		ListNode.printList(head);
		ListNode h = r.reverseList2(head);
        ListNode.printList(h);
		ListNode.printList(r.reverseBetween1(h, 3, 10));
		
	}

	// 递归版本，当问题规模变大时，时间过长，而且可能会产生栈溢出
	public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode pNode = head;
        ListNode preNode = head;
        for (;pNode.next != null;) {
            preNode = pNode;
            pNode = pNode.next;
        }
        preNode.next = null;
        ListNode newHead = head.next;
        reorderList(newHead);
        
        pNode.next = newHead;
        head.next = pNode;
    }
	
	/**
	 * 1 2 3 4 5 6 7 8 9 10 
	 * 1 10 2 9 3 8 4 7 5 6 
	 */
	// 非递归实现，仔细观察发现，重排序的链表其实是由 1 2 3 4 5 和 10 9 8 7 6 两个链表交叉合并的结果
	public void reorderList1(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) return;
		int len = 0;
		ListNode pNode = head;
		ListNode odd = head;
		ListNode even = head;
		for (;pNode != null;) {
			len ++;
			pNode = pNode.next;
		}
		pNode = head;
		for (int i=1;i < len/2; i++) {
			pNode = pNode.next;
		}
		even = pNode.next;
//		ListNode.printList(even);
		pNode.next = null;
		//头插法对even进行逆序
		ListNode dummby = new ListNode(0);
		dummby.next = null;
		ListNode pTemp = null;
		for (pNode=even;pNode!=null;) {
			pTemp = pNode; // 保存当前元素
			pNode = pNode.next; // pNode 前进
			// 当前元素插入dummby
			pTemp.next = dummby.next;
			dummby.next = pTemp; 
		}
		even = dummby.next;
//		ListNode.printList(odd);
//		ListNode.printList(even);
//		ListNode.printList(head);
		
		// 合并
		ListNode newHead = new ListNode(0);
		newHead.next = null;
		ListNode pTempOdd, pTempEven;
		for (pNode=newHead;even!=null && odd!=null;) {
			pTempOdd = odd;
			pTempEven = even;
			odd = odd.next;
			even = even.next;
			
			pNode.next = pTempOdd;
			pNode.next.next = pTempEven;
			
			pNode = pNode.next.next;
		}
		//处理最后一个可能多余的元素
		if (even!=null) {
			pNode.next = even;
		}
	}
	// 一般会使用一个多余的空头，这样写起来更方便，不用判断是不是头结点，从而会导致代码做特殊处理，但是在Java中申请heap空间是耗费时间的
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
        ListNode dummby = new ListNode(0);
        dummby.next = null;
        ListNode pNode = head;
        ListNode pTemp = null;
        for (;pNode != null;) {
            pTemp = pNode;
            pNode = pNode.next;
            pTemp.next = dummby.next;
            dummby.next = pTemp;
        }
        return dummby.next;
	}
	//因此这个版本使用stack空间，不使用堆，直接申明引用变量；
	public ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null) return head;
        ListNode newHead = null;
        for (;head != null;) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
	}
	//就地逆序链表的递归版本，所有的就地逆序的本质就是链表中的节点都是对象，你只需要改变这些对象中next的指针指向就行了。
	// 1 -> 2 -> 3 -> 4 -- n-1 -> n -> @ ,假设我们已经对 2到n多好了逆序，那么 2 肯定在已经逆序的链表最后， 然后又因为 1.next 指向 2，在求解子问题过程中并没有改变，因此 1.next.next = 1即可讲开头元素添加至结尾；
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode pNode = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return pNode;
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        if (m == n) return head;
        
        ListNode pNode = head;
        ListNode preM, pM, pN;
        pM = pN = preM = head;
        int i=1;
        for (;pNode!=null;) {
            if (m == 1) {
                preM = null;
                pM = head;
                break;
            }
            if (i == m) {
                pM = pNode; 
                break;
            }
            preM = pNode;
            pNode = pNode.next;
            i ++;
        }
        i = 1;
        for (pNode=head;pNode!=null;) {
            if (i == n) {
                pN = pNode;
                break;
            }
            pNode = pNode.next;
            i ++;
        }
        ListNode node = pN.next;
        ListNode newHead = null;
        pN.next = null;
        ListNode reverseHead = reverseList(pM);

        if (preM != null) {
            // 区间端的最后一个节点指向node
            preM.next.next = node;
            preM.next = reverseHead;
            newHead = head;
        }
        else {
            head.next = node;
            newHead = reverseHead;
        }
        return newHead;
    }
	public ListNode reverseBetween1(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        if (m == n) return head;
        //遇到头结点特殊处理或者需要计数的时候，采用冗余头结点会达到意想不到的效果；
        ListNode dummby = new ListNode(0);
        dummby.next = head;
        ListNode start = dummby;
        ListNode pre = dummby;
        ListNode end = dummby;
        //首先找到第m个节点的前驱，因为是单向链表；
        for (int i=1; i<m; i++) pre = pre.next;
        
        // 定位首位
        start = pre.next;
        end = pre.next;
        
        // 从pre节点开始做链表头插法实现逆序，当然要保存start的位置，到时候会变成末尾，然后直接接上end即可
        ListNode temp;
        pre.next = null;
        for (int i=1;i<=n-m+1;i++) {
        	temp = end;
        	end = end.next;
        	temp.next = pre.next;
        	pre.next = temp; 
        }
        start.next = end;
        return dummby.next;
    }
}
