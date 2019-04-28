package JavaAnswer.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import JavaAnswer.TreeNode;

public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView(root, 0, result);
        return result;
    }

    public void rightSideView(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(root.val);
        }
        rightSideView(root.right, level + 1, res);
        rightSideView(root.left, level + 1, res);
    }
}

class Solution199Iterative {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            result.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return result;
    }
}