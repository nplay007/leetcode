package JavaAnswer.one;

import JavaAnswer.ListNode;

public class Solution024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode ptr;
        while (pre.next != null && pre.next.next != null) {
            ptr = pre.next;
            pre.next = ptr.next;
            ptr.next = ptr.next.next;
            pre.next.next = ptr;
            pre = pre.next.next;
        }
        return dummy.next;
    }
}

class Solution024Recursion {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nhead = head.next;
        head.next = swapPairs(head.next.next);
        nhead.next = head;
        return nhead;
    }
}