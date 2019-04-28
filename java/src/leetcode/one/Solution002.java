package JavaAnswer.one;

import JavaAnswer.ListNode;

public class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int valOfl1 = l1 != null ? l1.val : 0;
            int valOfl2 = l2 != null ? l2.val : 0;
            int sum = valOfl1 + valOfl2 + carry;
            ptr.next = new ListNode(sum % 10);
            carry = sum / 10;
            ptr = ptr.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return dummy.next;
    }
}