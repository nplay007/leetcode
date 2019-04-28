package JavaAnswer.two;

public class Solution132 {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[s.length()] = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int a = i, b = i; a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b); a--, b++) {
                dp[a] = Math.min(dp[a], 1 + dp[b + 1]);
            }
            for (int a = i, b = i + 1; a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b); a--, b++) {
                dp[a] = Math.min(dp[a], 1 + dp[b + 1]);
            }
        }
        return dp[0];
    }
}