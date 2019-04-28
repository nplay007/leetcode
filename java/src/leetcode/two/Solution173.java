package JavaAnswer.two;

import java.util.Stack;

import JavaAnswer.TreeNode;

public class Solution173 {
    private Stack<TreeNode> stack;

    public Solution173(TreeNode root) {
        stack = new Stack<>();
        push(root);
    }

    public boolean hasNext() {
        return !stack.empty();
    }

    public int next() {
        TreeNode node = stack.pop();
        push(node.right);
        return node.val;
    }

    private void push(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}