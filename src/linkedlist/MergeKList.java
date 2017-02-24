package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKList {
	
	public ListNode mergeKListsWithProrityQueue(ListNode[] lists) {
		if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
		
		ListNode dumby = new ListNode(0);
		dumby.next = null;
		ListNode tail = dumby;
		for (int i=0;i<lists.length;i++) {
		    if (lists[i] != null) {
			    pq.add(lists[i]);
		    }
		}
		
		ListNode node = null;
		while (!pq.isEmpty()) {
			node = pq.poll();
			tail.next = node;			
			if (node.next != null) {
				pq.add(node.next);
			}
			tail = node;
		}
		return dumby.next;
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) return null;
		if (lists.length == 1) return lists[0];
		if (lists.length == 2) {
			return mergeTwoLists(lists[0], lists[1]);
		}
		int len = lists.length;
		ListNode[] left = new ListNode[len/2];
		ListNode[] right = new ListNode[len/2 + len%2];
		int i,j;
		for (i=0; i<left.length; i++) {
			left[i] = lists[i];
		}
		for (j=0; j<right.length; j++) {
			right[j] = lists[j+left.length];
		}
		
		ListNode l1 = mergeKLists(left);
		ListNode l2 = mergeKLists(right);
		
		return mergeTwoLists(l1, l2);
        
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
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
            }
            
            // 后续的头插法需要不断的更换新的冗余头节点，即每一组的最后一个节点
            if (i > k && i % k == 0) {
                dumby = pNode;
            }
            pNode = pNode.next;        
        }
        
		return dumbyHead.next;
    }
}