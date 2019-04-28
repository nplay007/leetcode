package JavaAnswer.two;

import JavaAnswer.ListNode;

public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode ptr = head;
        ListNode pre = dummy;
        // insert each node into the sorted part
        while (ptr != null) {
            ListNode next = ptr.next;
            while (pre.next != null && pre.next.val < ptr.val) {
                pre = pre.next;
            }
            ptr.next = pre.next;
            pre.next = ptr;
            pre = dummy;
            ptr = next;
        }
        return dummy.next;
    }
}