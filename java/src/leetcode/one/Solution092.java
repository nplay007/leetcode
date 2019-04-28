package JavaAnswer.one;

import JavaAnswer.ListNode;

public class Solution092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy, pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ptr = pre.next;
        for (int i = 0; i < n - m; i++) {
            ListNode tmp = ptr.next;
            ptr.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }
}