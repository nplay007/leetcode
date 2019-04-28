package JavaAnswer.four;

import JavaAnswer.TreeNode;

public class Solution333 {
    int result = 0;

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        int size = countBFS(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (size != -1) { // not a valid BST
            result = Math.max(result, size);
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }

    int countBFS(TreeNode root, int mn, int mx) {
        if (root == null) {
            return 0;
        }
        if (root.val <= mn || root.val >= mx) {
            return -1;
        }
        int left = countBFS(root.left, mn, root.val);
        if (left == -1) {
            return -1;
        }
        int right = countBFS(root.right, root.val, mx);
        if (right == -1) {
            return -1;
        }
        return left + right + 1;
    }
}