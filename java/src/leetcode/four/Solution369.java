package JavaAnswer.four;

import JavaAnswer.ListNode;

public class Solution369 {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, ptr = dummy;
        while (ptr.next != null) {
            ptr = ptr.next;
            if (ptr.val != 9) {
                pre = ptr;
            }
        }
        if (ptr.val != 9) {
            ptr.val++;
        }
        else {
            pre.val++;
            pre = pre.next;
            while (pre != null) {
                pre.val = 0;
                pre = pre.next;
            }
        }
        return dummy.val != 0 ? dummy : dummy.next;
    }
}