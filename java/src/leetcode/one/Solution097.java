package JavaAnswer.one;

public class Solution097 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length(), n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)) || dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[m][n];
    }
}

class Solution097Addtional {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length(), n = s2.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i <= m; i++) {
            dp[0] = dp[0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
            for (int j = 1; j <= n; j++) {
                dp[j] = dp[j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)) || dp[j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[n];
    }
}