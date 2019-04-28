package JavaAnswer.two;

import JavaAnswer.TreeNode;

public class Solution114 {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode node = root.left;
                while (node.right != null) {
                    node = node.right;
                }
                node.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            else {
                root = root.right;
            }
        }
    }
}