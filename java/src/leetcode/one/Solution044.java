package JavaAnswer.one;

public class Solution044 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            dp[0][i] = dp[0][i - 1] && (p.charAt(i - 1) == '*');
        }
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= p.length(); ++j) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                }
                else {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

class Solution044II {
    public boolean isMatch(String s, String p) {
        boolean[] dp = new boolean[p.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= p.length(); i++) {
            dp[i] = dp[i - 1] && (p.charAt(i - 1) == '*');
        }
        for (int i = 1; i <= s.length(); ++i) {
            boolean pre = dp[0];
            dp[0] = false;
            for (int j = 1; j <= p.length(); ++j) {
                boolean tmp = dp[j];
                if (p.charAt(j - 1) != '*') {
                    dp[j] = pre && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                }
                else {
                    dp[j] = dp[j] || dp[j - 1];
                }
                pre = tmp;
            }
        }
        return dp[p.length()];
    }
}