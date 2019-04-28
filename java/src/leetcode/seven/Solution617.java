package JavaAnswer.seven;

import java.util.Stack;

import JavaAnswer.TreeNode;

public class Solution617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
}

class Solution617II {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] { t1, t2 });
        while (!stack.isEmpty()) {
            TreeNode[] node = stack.pop();
            if (node[0] == null || node[1] == null) {
                continue;
            }
            node[0].val += node[1].val;
            if (node[0].left == null) {
                node[0].left = node[1].left;
            }
            else {
                stack.push(new TreeNode[] { node[0].left, node[1].left });
            }
            if (node[0].right == null) {
                node[0].right = node[1].right;
            }
            else {
                stack.push(new TreeNode[] { node[0].right, node[1].right });
            }
        }
        return t1;
    }
}