package JavaAnswer.three;

public class Solution213 {
    private int rob(int[] nums, int left, int right) {
        int cur = 0, pre = 0;
        for (int i = left; i <= right; i++) {
            int tmp = cur;
            cur = Math.max(cur, pre + nums[i]);
            pre = tmp;
        }
        return cur;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
}