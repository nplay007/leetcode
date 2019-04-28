package JavaAnswer.three;

import JavaAnswer.TreeNode;

public class Solution285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return root;
        }
        // the successor is either larger than p or null
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left != null ? left : root;
        }
    }
}

class Solution285Iterative {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        if (p.right != null) {
            TreeNode node = p.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        TreeNode prev = null;
        while (root != null) {
            if (root.val > p.val) {
                prev = root;
                root = root.left;
            }
            else if (root.val < p.val) {
                root = root.right;
            }
            else {
                break;
            }
        }
        return prev;
    }
}