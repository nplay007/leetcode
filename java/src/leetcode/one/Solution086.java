package JavaAnswer.one;

import JavaAnswer.ListNode;

public class Solution086 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode p1 = l1, p2 = l2;
        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            }
            else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p1.next = l2.next;
        p2.next = null;
        return l1.next;
    }
}