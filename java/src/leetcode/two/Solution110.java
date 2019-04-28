package JavaAnswer.two;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import JavaAnswer.TreeNode;

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(left - right) <= 1;
    }

    private int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
    }
}

class Solution110Iterative {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        TreeNode node = root, last = null;
        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || last == node.right) {
                node = stack.pop();
                int left = map.getOrDefault(node.left, 0);
                int right = map.getOrDefault(node.right, 0);
                if (Math.abs(left - right) > 1) {
                    return false;
                }
                map.put(node, 1 + Math.max(left, right));
                last = node;
                node = null;
            }
            else {
                node = node.right;
            }
        }
        return true;
    }
}