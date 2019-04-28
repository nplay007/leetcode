package JavaAnswer.two;

import JavaAnswer.TreeNode;

public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(0, nums.length - 1, nums);
    }

    private TreeNode sortedArrayToBST(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        int mid = (end - start) / 2 + start;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(start, mid - 1, nums);
        root.right = sortedArrayToBST(mid + 1, end, nums);
        return root;
    }
}