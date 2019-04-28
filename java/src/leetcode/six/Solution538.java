package JavaAnswer.six;

import JavaAnswer.TreeNode;

public class Solution538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.right);
        root.val += sum;
        sum = root.val;
        inorder(root.left);
    }
}