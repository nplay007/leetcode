package JavaAnswer.seven;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import JavaAnswer.TreeNode;

class Solution637DFS {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> result = new ArrayList<>();
        dfs(root, 0, result, count);
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i) / count.get(i));
        }
        return result;
    }

    public void dfs(TreeNode root, int i, List<Double> sum, List<Integer> count) {
        if (root == null) {
            return;
        }
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + root.val);
            count.set(i, count.get(i) + 1);
        }
        else {
            sum.add(1.0 * root.val);
            count.add(1);
        }
        dfs(root.left, i + 1, sum, count);
        dfs(root.right, i + 1, sum, count);
    }
}

class Solution637BFS {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }
}
