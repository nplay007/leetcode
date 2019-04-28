package JavaAnswer.three;

import java.util.ArrayList;
import java.util.List;

import JavaAnswer.TreeNode;

public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode root, String ans, List<String> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(ans + String.valueOf(root.val));
            return;
        }
        dfs(root.left, ans + String.valueOf(root.val) + "->", result);
        dfs(root.right, ans + String.valueOf(root.val) + "->", result);
    }
}