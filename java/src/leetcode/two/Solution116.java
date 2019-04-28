package JavaAnswer.two;

import JavaAnswer.TreeLinkNode;

public class Solution116 {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode startOfLevel = root;
        TreeLinkNode ptr;
        while (startOfLevel.left != null) {
            ptr = startOfLevel;
            while (ptr != null) {
                ptr.left.next = ptr.right;
                if (ptr.next != null) {
                    ptr.right.next = ptr.next.left;
                }
                ptr = ptr.next;
            }
            startOfLevel = startOfLevel.left;
        }
    }
}