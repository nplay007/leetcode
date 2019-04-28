package JavaAnswer.two;

import JavaAnswer.TreeNode;

public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        return buildTree(0, inorder.length - 1, inorder, 0, postorder.length - 1, postorder);
    }

    private TreeNode buildTree(int is, int ie, int[] inorder, int ps, int pe, int[] postorder) {
        if (is > ie || ps > pe) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int idx = 0;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == root.val) {
                idx = i;
                break;
            }
        }
        root.left = buildTree(is, idx - 1, inorder, ps, idx - is + ps - 1, postorder);
        root.right = buildTree(idx + 1, ie, inorder, idx - is + ps, pe - 1, postorder);
        return root;
    }
}