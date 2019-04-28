package JavaAnswer.one;

import JavaAnswer.ListNode;

public class Solution021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode ptr;
        if (l1.val < l2.val) {
            ptr = l1;
            ptr.next = mergeTwoLists(l1.next, l2);
        }
        else {
            ptr = l2;
            ptr.next = mergeTwoLists(l1, l2.next);
        }
        return ptr;
    }
}

class Solution021Recursion {
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            }
            else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        ptr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}