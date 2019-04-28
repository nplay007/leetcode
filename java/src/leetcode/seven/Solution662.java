package JavaAnswer.seven;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import JavaAnswer.TreeNode;

public class Solution662 {
    int result;

    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>(); // level : the leftest node position
        dfs(root, 0, 0, map);
        return result;
    }

    public void dfs(TreeNode root, int depth, int position, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.computeIfAbsent(depth, x -> position);
        result = Math.max(result, position - map.get(depth) + 1); // right - left
        dfs(root.left, depth + 1, 2 * position, map);
        dfs(root.right, depth + 1, 2 * position + 1, map);
    }
}

class Solution662II {
    class TreeNodePair {
        TreeNode left;
        TreeNode right;
        int level;

        TreeNodePair(TreeNode root, int level) {
            left = root.left;
            right = root.right;
            this.level = level;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNodePair> queue = new LinkedList<>();
        queue.add(new TreeNodePair(root, 0));
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = 0, right = 0;
            for (int i = 0; i < size; i++) {
                TreeNodePair node = queue.poll();
                if (i == 0) {
                    left = node.level;
                }
                if (i == size - 1) {
                    right = node.level;
                }
                if (node.left != null) {
                    queue.add(new TreeNodePair(node.left, node.level * 2));
                }
                if (node.right != null) {
                    queue.add(new TreeNodePair(node.right, node.level * 2 + 1));
                }
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}