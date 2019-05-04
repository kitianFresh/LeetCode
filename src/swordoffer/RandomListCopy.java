package swordoffer;
import java.util.HashMap;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class RandomListCopy {
	// [复杂链表的复制](https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba?tpId=13&tqId=11178&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)
	public RandomListNode Clone(RandomListNode pHead)
    {
        HashMap<RandomListNode, RandomListNode> posMap = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dumby = new RandomListNode(0);
        RandomListNode tail = dumby;
        RandomListNode head = pHead;
        while (head != null) {
            RandomListNode node = new RandomListNode(0);
            node.label = head.label;
            tail.next = node;
            tail = tail.next;
            posMap.put(head, node);
            head = head.next;
        }
        head = pHead;
        RandomListNode cloneHead = dumby.next;
        while (head != null) {
            cloneHead.random = posMap.get(head.random);
            head = head.next;
            cloneHead = cloneHead.next;
        }
        return dumby.next;
    }
}
