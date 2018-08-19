package probabilitystatistics;

import java.util.Random;

import linkedlist.ListNode;

public class ReservoirSample {

	
	// [382. Linked List Random Node](https://leetcode.com/problems/linked-list-random-node/description/)
	/**
	 * @param head
	 *            The linked list's head. Note that the head is guaranteed to be
	 *            not null, so it contains at least one node.
	 */
	private ListNode res;
	Random r;

	public ReservoirSample(ListNode head) {
		res = head;
		r = new Random(0);
	}

	/** Returns a random node's value. */
	public int getRandom() {
		ListNode p = res;
		int i = 1;
		while (p != null) {
			int m = r.nextInt(i) + 1;
			if (m == 1) {
				res = p;
			}
			p = p.next;
			i++;
		}
		return res.val;
	}

	
}
