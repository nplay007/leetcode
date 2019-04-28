package JavaAnswer.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import JavaAnswer.TreeNode;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, 0, res);
        return res;
    }

    public void levelOrder(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            res.get(level).add(root.val);
        }
        else {
            res.get(level).add(0, root.val);
        }
        levelOrder(root.left, level + 1, res);
        levelOrder(root.right, level + 1, res);
    }
}

class Solution103Iterative {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int sizeOfLevel = queue.size();
            List<Integer> listOfLevel = new ArrayList<>();
            for (int i = 0; i < sizeOfLevel; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 1) {
                    listOfLevel.add(node.val);
                }
                else {
                    listOfLevel.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
            res.add(listOfLevel);
        }
        return res;
    }
}