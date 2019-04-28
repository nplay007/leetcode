package JavaAnswer.three;

import JavaAnswer.TreeNode;

public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        if ((root.val - p.val) * (root.val - q.val) > 0) {
            if (root.val > p.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            else {
                return lowestCommonAncestor(root.right, p, q);
            }
        }
        return root;
    }
}