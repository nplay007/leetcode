package interview;

import JavaAnswer.TreeNode;

public class FindSecondLargest {
    public TreeNode findSecondLargest(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = null;
        if (root.right != null) {
            while (root.right != null) {
                node = root;
                root = root.right;
            }
            return node;
        }
        else if (root.left != null) {
            root = root.left;
            while (root.right != null) {
                root = root.right;
            }
            return root;
        }
        else {
            return null;
        }
    }
}
