package JavaAnswer.three;

import JavaAnswer.TreeNode;

public class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = 0, hr = 0;
        TreeNode left = root, right = root;
        while (left != null) {
            hl++;
            left = left.left;
        }
        while (right != null) {
            hr++;
            right = right.right;
        }

        if (hl == hr) {
            return (1 << hl) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}