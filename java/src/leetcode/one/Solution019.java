package JavaAnswer.one;

import JavaAnswer.ListNode;

public class Solution019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        // move to previous node of delete node
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        for (; fast.next != null; fast = fast.next) {
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}