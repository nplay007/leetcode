package JavaAnswer.three;

import JavaAnswer.TreeNode;

public class Solution298 {
    public int longestConsecutive(TreeNode root) {
        return dfs(root, null, 0);
    }

    private int dfs(TreeNode child, TreeNode parent, int res) {
        if (child == null) {
            return res;
        }
        res = (parent != null && child.val == parent.val + 1) ? res + 1 : 1;
        return Math.max(res, Math.max(dfs(child.left, child, res), dfs(child.right, child, res)));
    }
}