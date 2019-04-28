package JavaAnswer.two;

import java.util.Stack;

import JavaAnswer.TreeNode;

public class Solution112 {
    // postorder traversal
    public boolean hasPathSum(TreeNode root, int sum) {
        int cur = 0;
        TreeNode last = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                cur += root.val;
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null && root.left == null && cur == sum) {
                return true;
            }
            if (root.right == null || last == root.right) {
                last = root;
                stack.pop();
                cur -= root.val;
                root = null;
            }
            else {
                root = root.right;
            }
        }
        return false;
    }
}

class Solution112Recrusion {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.right == null && root.left == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}