package JavaAnswer.one;

import JavaAnswer.ListNode;

public class Solution025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        int lengthOfList = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head;
        while (pre != null) {
            pre = pre.next;
            lengthOfList++;
        }
        pre = dummy;
        while (lengthOfList >= k) {
            lengthOfList -= k;
            ListNode ptr = pre.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode next = ptr.next;
                ptr.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = ptr;
        }
        return dummy.next;
    }
}

class Solution025Recrusion {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        int count = 0;
        while (ptr != null && count != k) {
            ptr = ptr.next;
            count++;
        }
        if (count == k) {
            ptr = reverseKGroup(ptr, k);
            while (count-- > 0) {
                ListNode tmp = head.next;
                head.next = ptr;
                ptr = head;
                head = tmp;
            }
            head = ptr;
        }
        return head;
    }
}