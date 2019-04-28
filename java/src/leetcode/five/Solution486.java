package JavaAnswer.five;

public class Solution486 {
    public boolean PredictTheWinner(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = nums.length; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[nums.length - 1] >= 0;
    }
}

class Solution486II {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length];
        for (int i = nums.length; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
}