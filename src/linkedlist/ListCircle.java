package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class ListCircle {
	
	public boolean hasCycle(ListNode head) {
		Set<ListNode> nodes = new HashSet<ListNode>();
        ListNode pNode = head;
        while (pNode != null) {
        	if (nodes.contains(pNode)) {
        		return true;
        	}
        	nodes.add(pNode);
        	pNode = pNode.next;
        }
        return false;
    }
	// 双指针法,速度差, (vt - l) % c == (2vt - l) % c
	public boolean hasCycle1Space(ListNode head) {
		if (head == null) return false;
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow= slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
	// 当快指针和慢指针相遇时，会满足如下公式：  s -> m 距离为 a, m->s 距离为 b， head 到 S 距离为 l， 环长 c; 那么有 
	// (n * c + l + a)/2v = (m*c + l + a)/v; c - a = b; 得到 (b + (n-2m-1)c) / v = l / v; 也即是 慢指针如果此时和一个指向head的指针同时以相同速度出发，即可想遇到cycle起始点
	/**
	 *  --------S--------|
	 *          |        |
	 *          |        |
	 *          |        |
	 *          |___m____|
	 * 
	 * 
	 */
	public ListNode detectCycle(ListNode head) {
		if (head == null) return null;
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				while (head != slow) {
					head = head.next;
					slow = slow.next;
				}
				
				return head;
			}
		}
		return null;
	}
}
