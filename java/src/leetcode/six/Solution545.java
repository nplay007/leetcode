package JavaAnswer.six;

import java.util.ArrayList;
import java.util.List;

import JavaAnswer.TreeNode;

public class Solution545 {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }
        nodes.add(root.val);
        leftBoundary(root.left, nodes);
        leaves(root.left, nodes);
        leaves(root.right, nodes);
        rightBoundary(root.right, nodes);
        return nodes;
    }

    public void leftBoundary(TreeNode root, List<Integer> nodes) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        nodes.add(root.val);
        if (root.left == null) {
            leftBoundary(root.right, nodes);
        }
        else {
            leftBoundary(root.left, nodes);
        }
    }

    public void rightBoundary(TreeNode root, List<Integer> nodes) {
        if (root == null || (root.right == null && root.left == null)) {
            return;
        }
        if (root.right == null) {
            rightBoundary(root.left, nodes);
        }
        else {
            rightBoundary(root.right, nodes);
        }
        nodes.add(root.val); // add after child visit(reverse)
    }

    public void leaves(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            nodes.add(root.val);
            return;
        }
        leaves(root.left, nodes);
        leaves(root.right, nodes);
    }
}
