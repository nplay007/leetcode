package JavaAnswer.four;

public class Solution312 {
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2];
        for (int i = 0; i < nums.length + 2; i++) {
            if (i == 0 || i == nums.length + 1) {
                balloons[i] = 1;
            }
            else {
                balloons[i] = nums[i - 1];
            }
        }
        int n = balloons.length;
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i) {
                    dp[left][right] = Math.max(dp[left][right], balloons[left] * balloons[i] * balloons[right] + dp[left][i] + dp[i][right]);
                }
            }
        return dp[0][n - 1];
    }
}