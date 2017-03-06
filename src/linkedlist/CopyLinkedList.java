package linkedlist;

import java.util.HashMap;

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
	
	public static void printList(RandomListNode head) {
		for (;head != null;) {
			System.out.print(head.label + ":" + head.random + " ");
			head = head.next;
		}
		System.out.println();
	}
};
public class CopyLinkedList {
	public static void main(String[] args) {
		int[] arr = {3,4,1};
		ListNode dummy = new ListNode(-1);
		dummy.next = null;
		ListNode tail = dummy;
		for (int i=0; i<arr.length; i++) {
			ListNode node = new ListNode(arr[i]);
			tail.next = node;
			tail = tail.next;
		}
		ListNode.printList(dummy.next);
		System.out.println();
		
		
		CopyLinkedList cll = new CopyLinkedList();
		RandomListNode dummy1 = new RandomListNode(-1);
		RandomListNode tail1 = dummy1;
		for (int i=0; i<arr.length; i++) {
			RandomListNode node = new RandomListNode(arr[i]);
			tail1.next = node;
			tail1 = tail1.next;
		}
		RandomListNode.printList(dummy1.next);
		RandomListNode.printList(cll.copyRandomList(dummy1.next));
	}
	
	
	//138. Copy List with Random Pointer
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;
		HashMap<RandomListNode, Integer> mapOld = new HashMap<RandomListNode, Integer>();
		HashMap<Integer, RandomListNode> mapNew = new HashMap<Integer, RandomListNode>();
		int pos = 0;
		RandomListNode p, tail;
		RandomListNode dummy = new RandomListNode(-1);
		p = head;
		tail = dummy;
		while (p != null) {
			mapOld.put(p, pos); // 记录原链表 node -> pos 键值对

			// 深度复制节点
			RandomListNode node = new RandomListNode(-1);
			node.next = null;
			node.label = p.label;
			tail.next = node;
			tail = node;

			mapNew.put(pos, node); // 记录新链表 pos -> node 键值对
			pos++;
			p = p.next;
		}
		RandomListNode.printList(dummy.next);
		RandomListNode p1, p2;
		p1 = head;
		p2 = dummy.next;
		while (p2 != null) {
			p2.random = (p1.random == null ? null : mapNew.get(mapOld.get(p1.random)));
			p1 = p1.next;
			p2 = p2.next;
		}

		return dummy.next;
	}
}
