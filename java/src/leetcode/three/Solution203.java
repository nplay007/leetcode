package JavaAnswer.three;

import JavaAnswer.ListNode;

public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}

class Solution203Iterative {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy;
        while (ptr.next != null) {
            if (ptr.next.val == val) {
                ptr.next = ptr.next.next;
            }
            else {
                ptr = ptr.next;
            }
        }
        return dummy.next;
    }
}