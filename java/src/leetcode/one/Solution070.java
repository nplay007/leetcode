package JavaAnswer.one;

public class Solution070 {
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

class Solution070Addtional {
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        int pre = 1, cur = 1;
        for (int i = 2; i <= n; i++) {
            cur = cur + pre;
            pre = cur - pre;
        }
        return cur;
    }
}