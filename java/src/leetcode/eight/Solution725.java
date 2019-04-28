package JavaAnswer.eight;

import JavaAnswer.ListNode;

public class Solution725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode ptr = root;
        int listSize = 0;
        while (ptr != null) {
            ptr = ptr.next;
            listSize++;
        }

        int sublistSize = listSize / k, remainder = listSize % k;

        ListNode[] result = new ListNode[k];
        ptr = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = ptr;
            for (int j = 0; j < sublistSize + (i < remainder ? 1 : 0) - 1; ++j) {
                if (ptr != null) {
                    ptr = ptr.next;
                }
            }
            if (ptr != null) {
                ListNode prev = ptr;
                ptr = ptr.next;
                prev.next = null;
            }
            result[i] = head;
        }
        return result;
    }
}