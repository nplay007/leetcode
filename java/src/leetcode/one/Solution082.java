package JavaAnswer.one;

import JavaAnswer.ListNode;

public class Solution082 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next == fast) {
                slow = slow.next;
            }
            else {
                slow.next = fast.next;
            }
            fast = fast.next;
        }
        return dummy.next;
    }
}