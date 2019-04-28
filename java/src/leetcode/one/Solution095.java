package JavaAnswer.one;

import java.util.ArrayList;
import java.util.List;

import JavaAnswer.TreeNode;

public class Solution095 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> child = new ArrayList<>();
        if (start > end) {
            child.add(null);
            return child;
        }
        for (int i = start; i <= end; i++) {
            for (TreeNode left : generateTrees(start, i - 1)) {
                for (TreeNode right : generateTrees(i + 1, end)) {
                    TreeNode mid = new TreeNode(i);
                    mid.left = left;
                    mid.right = right;
                    child.add(mid);
                }
            }
        }
        return child;
    }
}

class Solution095DP {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        List<List<TreeNode>> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            result.add(new ArrayList<>());
        }
        result.get(0).add(null);
        for (int i = 1; i <= n; i++) { // i from 1 to n, G(i)
            for (int j = 1; j <= i; j++) { // j from 1 to i, root
                for (TreeNode left : result.get(j - 1)) { // G(j-1)
                    for (TreeNode right : result.get(i - j)) { // G(i-j)
                        TreeNode root = new TreeNode(j);
                        root.left = left;
                        // For right nodes, starting at j+1, need offset = j+1
                        root.right = clone(right, j);
                        result.get(i).add(root);
                    }
                }
            }
        }
        return result.get(n);
    }

    private TreeNode clone(TreeNode right, int offset) {
        if (right == null) {
            return null;
        }
        TreeNode root = new TreeNode(right.val + offset);
        root.left = clone(right.left, offset);
        root.right = clone(right.right, offset);
        return root;
    }
}