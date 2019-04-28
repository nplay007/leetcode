package interview;

import java.util.Stack;

import JavaAnswer.TreeNode;

public class TernaryToTree {
    public TreeNode getBinaryTree(char[] expression) {
        if (expression == null || expression.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(expression[0]);
        stack.push(root);

        for (int i = 1; i < expression.length; i += 2) {
            char Op = expression[i];
            char ch = expression[i + 1];
            TreeNode node = new TreeNode(ch);
            if (Op == '?') {
                stack.peek().left = node;
            }
            else if (Op == ':') {
                stack.pop();
                while (stack.peek().right != null) {
                    stack.pop();
                }
                stack.peek().right = node;
            }
        }
        return root;
    }
}
