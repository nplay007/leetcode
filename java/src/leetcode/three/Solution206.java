package JavaAnswer.three;

import JavaAnswer.ListNode;

public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return nhead;
    }
}


class Solution206Iterative {
    public ListNode reverseList(ListNode head) {
        ListNode nhead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = nhead;
            nhead = head;
            head = tmp;
        }
        return nhead;
    }
}
