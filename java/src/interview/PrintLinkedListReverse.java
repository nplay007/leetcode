package interview;

import java.util.ArrayList;
import java.util.List;

import JavaAnswer.ListNode;

public class PrintLinkedListReverse {
    public static void reverseList(ListNode head) {
        if (head == null) {
            return;
        }
        // count the length
        ListNode ptr = head;
        int length = 0;
        while (ptr != null) {
            ptr = ptr.next;
            length++;
        }
        List<Integer> result = new ArrayList<>();
        reverseList(head, length, result);
    }

    private static void reverseList(ListNode head, int length, List<Integer> result) {
        if (length == 1) {
            result.add(head.val);
            return;
        }
        ListNode rightHead = head;
        int count = 0;
        while (count < length / 2) {
            rightHead = rightHead.next;
            count++;
        }
        // O(logn) time
        reverseList(rightHead, length / 2, result);
        reverseList(head, length - length / 2, result);
    }
}
