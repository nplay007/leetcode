package JavaAnswer.three;

import JavaAnswer.TreeNode;

// O(h)
public class Solution270 {
    public int closestValue(TreeNode root, double target) {
        int rootVal = root.val;
        TreeNode child = target < rootVal ? root.left : root.right;
        if (child == null) {
            return rootVal;
        }
        int childVal = closestValue(child, target);
        return Math.abs(rootVal - target) < Math.abs(childVal - target) ? rootVal : childVal;
    }
}