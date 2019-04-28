package JavaAnswer.two;

import java.util.Stack;

import JavaAnswer.TreeNode;

public class Solution129 {
    // Sum Root to Leaf Numbers
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int res) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val + res * 10;
        }
        return sumNumbers(root.left, res * 10 + root.val) + sumNumbers(root.right, res * 10 + root.val);
    }
}

class Solution129Iterative {
    // postorder traversal
    public int sumNumbers(TreeNode root) {
        int sum = 0, cur = 0;
        TreeNode last = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                cur = cur * 10 + root.val;
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null && root.left == null) {
                sum += cur;
            }
            if (root.right == null && root.right == last) {
                stack.pop();
                last = root;
                cur /= 10;
                root = null;
            }
            else {
                root = root.right;
            }
        }
        return sum;
    }
}