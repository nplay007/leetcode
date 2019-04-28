package JavaAnswer.five;

import JavaAnswer.TreeNode;

public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if (root.left == null || root.right == null) {
                root = root.left != null ? root.left : root.right;
            }
            else {
                TreeNode minNode = root.right;
                while (minNode.left != null) {
                    minNode = minNode.left;
                }
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }
}
