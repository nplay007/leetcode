package JavaAnswer.two;

import JavaAnswer.TreeNode;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return buildTree(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder);
    }

    private TreeNode buildTree(int ps, int pe, int[] preorder, int is, int ie, int[] inorder) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int index = 0;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == preorder[ps]) {
                index = i;
                break;
            }
        }
        root.left = buildTree(ps + 1, index - is + ps, preorder, is, index - 1, inorder);
        root.right = buildTree(index - is + ps + 1, pe, preorder, index + 1, ie, inorder);
        return root;
    }
}