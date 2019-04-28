package JavaAnswer.two;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import JavaAnswer.TreeNode;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        levelOrderBottom(root, 0, res);
        return res;
    }

    public void levelOrderBottom(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(0, new LinkedList<>()); // insert
        }
        levelOrderBottom(root.left, level + 1, res);
        levelOrderBottom(root.right, level + 1, res);
        res.get(res.size() - level - 1).add(root.val); // the reverse
    }
}

class Solution107Iterative {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int sizeOfLevel = queue.size();
            List<Integer> listOfLevel = new LinkedList<>();
            for (int i = 0; i < sizeOfLevel; i++) {
                TreeNode node = queue.poll();
                listOfLevel.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            res.add(0, listOfLevel);
        }
        return res;
    }
}