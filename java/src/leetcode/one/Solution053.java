package JavaAnswer.one;

public class Solution053 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSub = nums[0], curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSub = Math.max(maxSub, curMax);
        }
        return maxSub;
    }
}