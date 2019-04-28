package JavaAnswer.two;

import JavaAnswer.ListNode;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode nhead = slow.next;
        slow.next = null;
        head = sortList(head);
        nhead = sortList(nhead);
        return mergeList(head, nhead);
    }

    private ListNode mergeList(ListNode fast, ListNode slow) {
        if (fast == null || slow == null) {
            return fast == null ? slow : fast;
        }
        ListNode head = null;
        if (fast.val < slow.val) {
            head = fast;
            head.next = mergeList(fast.next, slow);
        }
        else {
            head = slow;
            head.next = mergeList(fast, slow.next);
        }
        return head;
    }
}