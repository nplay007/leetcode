package JavaAnswer.three;

import JavaAnswer.ListNode;

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode nhead = null;
        while (fast != null) {
            ListNode tmp = fast.next;
            fast.next = nhead;
            nhead = fast;
            fast = tmp;
        }
        while (head != null && nhead != null) {
            if (head.val != nhead.val) {
                return false;
            }
            head = head.next;
            nhead = nhead.next;
        }
        return true;
    }
}