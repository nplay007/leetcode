package JavaAnswer.one;

import JavaAnswer.ListNode;

public class Solution083 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ptr = head;
        while (ptr != null) {
            while (ptr.next != null && ptr.next.val == ptr.val) {
                ptr.next = ptr.next.next;
            }
            ptr = ptr.next;
        }
        return head;
    }
}