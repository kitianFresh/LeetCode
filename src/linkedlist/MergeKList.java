package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKList {

	public ListNode mergeKListsWithProrityQueue(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		if (lists.length == 1)
			return lists[0];
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val)
					return -1;
				else if (o1.val == o2.val)
					return 0;
				else
					return 1;
			}
		});

		ListNode dumby = new ListNode(0);
		dumby.next = null;
		ListNode tail = dumby;
		for (int i = 0; i < lists.length; i++) {
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

	public ListNode dc(ListNode[] lists, int left, int right) {
        if (lists == null || lists.length < 1) return null;
        if (left == right) return lists[left];
        int mid = (left + right)/2;
        ListNode l = dc(lists, left, mid);
        ListNode r = dc(lists, mid+1, right);
        return mergeTwoLists(l, r);
    }
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length < 1) return null;
        return dc(lists, 0, lists.length-1);
    }
    
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null)
			return null;
		if (lists.length == 1)
			return lists[0];
		if (lists.length == 2) {
			return mergeTwoLists(lists[0], lists[1]);
		}
		int len = lists.length;
		ListNode[] left = new ListNode[len / 2];
		ListNode[] right = new ListNode[len / 2 + len % 2];
		int i, j;
		for (i = 0; i < left.length; i++) {
			left[i] = lists[i];
		}
		for (j = 0; j < right.length; j++) {
			right[j] = lists[j + left.length];
		}

		ListNode l1 = mergeKLists(left);
		ListNode l2 = mergeKLists(right);

		return mergeTwoLists(l1, l2);

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
