package linkedlist;

public class ReorderLinkList {
	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		ListNode head = ListNode.constructTailStyleByArray(a);
		
		ListNode.printList(head);
		ReorderLinkList r = new ReorderLinkList();
		r.reorderList1(head);
		ListNode.printList(head);
		
		ListNode h = ListNode.constructTailStyleByArray(a);
		ListNode.printList(h);
		r.reorderList(h);
		ListNode.printList(h);
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
}
