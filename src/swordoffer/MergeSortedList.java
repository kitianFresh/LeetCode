package swordoffer;

public class MergeSortedList {
	public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null || list2 == null) return list1 == null ? list2 : list1;
        ListNode head = Merge(list1.next, list2.next);
        if (list1.val < list2.val) {
            list2.next = head;
            list1.next = list2;
            return list1;
        } else {
            list1.next = head;
            list2.next = list1;
            return list2;
        }
    }
}
