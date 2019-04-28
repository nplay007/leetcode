package JavaAnswer.one;

import JavaAnswer.ListNode;

public class Solution061 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int len = 0;
        ListNode ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            len++;
        }
        k %= len;
        if (k == 0) {
            return head;
        }
        ptr = head;
        ListNode pre = head;
        for (int i = 0; i < k; i++) {
            ptr = ptr.next;
        }
        while (ptr.next != null) {
            ptr = ptr.next;
            pre = pre.next;
        }
        ptr.next = head;
        head = pre.next;
        pre.next = null;
        return head;
    }
}