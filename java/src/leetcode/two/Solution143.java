package JavaAnswer.two;

import JavaAnswer.ListNode;

public class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //split
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        //reverse half part
        ListNode nhead = null;
        while (fast != null) {
            ListNode tmp = fast.next;
            fast.next = nhead;
            nhead = fast;
            fast = tmp;
        }
        //merge
        for (slow = head, fast = nhead; slow != null;) {
            ListNode tmp = slow.next;
            slow.next = fast;
            slow = fast;
            fast = tmp;
        }
    }
}