package JavaAnswer.three;

import JavaAnswer.TreeNode;

public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // this is impossible left == null && right == null
        if (left == null || right == null) {
            return left == null ? right : left;
        }
        else {
            return root;
        }
    }
}