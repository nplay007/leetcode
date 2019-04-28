package JavaAnswer.two;

import JavaAnswer.TreeLinkNode;

public class Solution117 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode startOfLevel = root;
        TreeLinkNode startOfNext = null;
        TreeLinkNode connectNext = null, ptr = null;
        while (startOfLevel != null) {
            startOfNext = null;
            connectNext = null;
            ptr = startOfLevel;
            while (ptr != null) {
                if (startOfNext == null) {
                    startOfNext = ptr.left != null ? ptr.left : ptr.right;
                }
                if (ptr.left != null) {
                    if (connectNext != null) {
                        connectNext.next = ptr.left;
                    }
                    connectNext = ptr.left;
                }
                if (ptr.right != null) {
                    if (connectNext != null) {
                        connectNext.next = ptr.right;
                    }
                    connectNext = ptr.right;
                }
                ptr = ptr.next;
            }
            startOfLevel = startOfNext;
        }
    }
}