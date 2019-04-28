package JavaAnswer.two;

import JavaAnswer.ListNode;
import JavaAnswer.TreeNode;

public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode nhead = slow.next;
        slow.next = null;
        TreeNode root = new TreeNode(nhead.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(nhead.next);
        return root;
    }
}