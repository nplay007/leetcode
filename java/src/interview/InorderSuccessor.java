package interview;

// Write an algorithm to find the in-order successor of a given node in a binary search tree.
// You may assume that each node has a link to its parent.

// TreeNode does not have pointer to parent

// iterative BFS

public class InorderSuccessor {
    public TreeNode successor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.value > p.value) {
                res = root;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return res;
    }

    public TreeNode successorII(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.value > p.value) {
            TreeNode left = successorII(root.left, p);
            return left == null ? root : left;
        }
        else {
            return successor(root.right, p);
        }
    }

    // predecessor
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.value < p.value) {
            TreeNode right = inorderPredecessor(root.right, p);
            return right == null ? root : right;
        }
        else {
            return inorderPredecessor(root.left, p);
        }
    }

    // TreeNode has pointer to parent node

    public TreeNode inOrderSuccessor(TreeNode n) {
        if (n == null) {
            return null;
        }
        if (n.right != null) {
            return leftMostChild(n.right);
        }
        else {
            TreeNode cur = n, p = n.parent;
            while (p != null && p.left != cur) {
                cur = p;
                p = p.parent;
            }
            return p;
        }
    }

    private TreeNode leftMostChild(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}