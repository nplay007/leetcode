package JavaAnswer.two;

import JavaAnswer.TreeNode;

public class Solution124 {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxSum;
    }

    private int maxPathDown(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));
        maxSum = Math.max(maxSum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}