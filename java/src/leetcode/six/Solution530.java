package JavaAnswer.six;

import java.util.TreeSet;

import JavaAnswer.TreeNode;

public class Solution530 {
    private int absDiff = Integer.MAX_VALUE;
    private TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return absDiff;
        }
        getMinimumDifference(root.left);
        if (pre != null) {
            absDiff = Math.min(absDiff, root.val - pre.val);
        }
        pre = root;
        getMinimumDifference(root.right);
        return absDiff;
    }
}

class Solution530TreeSet {
    TreeSet<Integer> set = new TreeSet<>();
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }

        if (!set.isEmpty()) {
            if (set.floor(root.val) != null) {
                min = Math.min(min, root.val - set.floor(root.val));
            }
            if (set.ceiling(root.val) != null) {
                min = Math.min(min, set.ceiling(root.val) - root.val);
            }
        }
        set.add(root.val);
        getMinimumDifference(root.left);
        getMinimumDifference(root.right);
        return min;
    }
}
