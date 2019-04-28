package JavaAnswer.seven;

import JavaAnswer.TreeNode;

public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    public TreeNode construct(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int idx = indefOfMaximum(nums, start, end);
        TreeNode root = new TreeNode(nums[idx]);
        root.left = construct(nums, start, idx);
        root.right = construct(nums, idx + 1, end);
        return root;
    }

    public int indefOfMaximum(int[] nums, int start, int end) {
        int idx = start;
        for (int i = start; i < end; i++) {
            if (nums[idx] < nums[i]) {
                idx = i;
            }
        }
        return idx;
    }
}