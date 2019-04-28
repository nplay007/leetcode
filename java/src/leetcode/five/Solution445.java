package JavaAnswer.five;

import java.util.Stack;

import JavaAnswer.ListNode;

public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.add(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ptr = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int x = s1.isEmpty() ? 0 : s1.pop();
            int y = s2.isEmpty() ? 0 : s2.pop();
            int sum = carry + x + y;
            ptr.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = ptr;
            ptr = head;
            carry = sum / 10;
        }
        return ptr.val == 0 ? ptr.next : ptr;
    }
}

class Solution445II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        int size1 = getSize(l1);
        int size2 = getSize(l2);
        ListNode dummy = new ListNode(1);
        dummy.next = size1 < size2 ? dfs(l2, l1, size2 - size1) : dfs(l1, l2, size1 - size2);
        if (dummy.next.val > 9) {
            dummy.next.val %= 10;
            return dummy;
        }
        return dummy.next;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    private ListNode dfs(ListNode l1, ListNode l2, int diff) {
        if (l1 == null) {
            return l1;
        }
        ListNode head = diff == 0 ? new ListNode(l1.val + l2.val) : new ListNode(l1.val);
        ListNode next = diff == 0 ? dfs(l1.next, l2.next, 0) : dfs(l1.next, l2, diff - 1);
        if (next != null && next.val > 9) {
            head.val += 1;
            next.val %= 10;
        }
        head.next = next;
        return head;
    }
}