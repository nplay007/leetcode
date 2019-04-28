package JavaAnswer.seven;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import JavaAnswer.TreeNode;

public class Solution606 {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        else if (root.left == null && root.right == null) {
            return String.valueOf(root.val);
        }
        else if (root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        }
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }
}

class Solution606Iterative {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (visited.contains(root)) {
                stack.pop();
                sb.append(")");
            }
            else {
                visited.add(root);
                sb.append("(").append(root.val);
                if (root.left == null && root.right != null) {
                    sb.append("()");
                }
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
        return sb.substring(1, sb.length() - 1);
    }
}