package JavaAnswer.five;

import java.util.LinkedList;
import java.util.Queue;

import JavaAnswer.TreeNode;

public class Solution449 {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append("#");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] nodes = data.split("#");
        Queue<Integer> queue = new LinkedList<>();
        for (String node : nodes) {
            queue.add(Integer.parseInt(node));
        }
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<Integer> queue) {
        if (queue == null || queue.size() == 0) {
            return null;
        }
        Queue<Integer> small = new LinkedList<>();
        TreeNode root = new TreeNode(queue.poll());
        while (!queue.isEmpty() && queue.peek() < root.val) {
            small.add(queue.poll());
        }
        root.left = deserialize(small);
        root.right = deserialize(queue);
        return root;
    }
}