package JavaAnswer.two;

public class Solution198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre = 0, cur = 0;
        for (int num : nums) {
            int tmp = cur;
            cur = Math.max(num + pre, cur);
            pre = tmp;
        }
        return cur;
    }
}

class Solution198DP {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length];
    }
}