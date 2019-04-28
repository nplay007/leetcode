package JavaAnswer.five;

public class Solution413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int cur = 0;
        int result = 0;
        for (int i = 2; i < nums.length; i++)
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                cur ++;
                result += cur;
            }
            else {
                cur = 0;
            }
        return result;
    }
}

class Solution413II {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        int result = 0;
        for (int i = 2; i < dp.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                result += dp[i];
            }
        }
        return result;
    }
}
