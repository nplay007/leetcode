package JavaAnswer.one;

import java.util.Stack;

import JavaAnswer.TreeNode;

public class Solution099 {
    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        traverse(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (first == null && prev != null && prev.val >= root.val) {
            first = prev;
        }
        if (first != null && prev != null && prev.val >= root.val) {
            second = root;
        }
        prev = root;
        traverse(root.right);
    }
}

class Solution099Addtional {
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (first == null && prev != null && prev.val >= root.val) {
                first = prev;
            }
            if (first != null && prev != null && prev.val >= root.val) {
                second = root;
            }
            prev = root;
            root = root.right;
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}

class Solution099Morris {
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, pre = null;
        TreeNode temp = null;
        while (root != null) {
            if (root.left != null) {
                temp = root.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                if (temp.right != null) {
                    if (pre != null && pre.val > root.val) {
                        if (first == null) {
                            first = pre;
                            second = root;
                        }
                        else {
                            second = root;
                        }
                    }
                    pre = root;
                    temp.right = null;
                    root = root.right;
                }
                else {
                    temp.right = root;
                    root = root.left;
                }
            }
            else {
                if (pre != null && pre.val > root.val) {
                    if (first == null) {
                        first = pre;
                        second = root;
                    }
                    else {
                        second = root;
                    }
                }
                pre = root;
                root = root.right;
            }
        }
        if (first != null && second != null) {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
}