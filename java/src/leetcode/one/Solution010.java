package JavaAnswer.one;

public class Solution010 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < p.length(); i += 2) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i - 1];
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && isCharMatch(s.charAt(i - 1), p.charAt(j - 1));
                }
                else {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && isCharMatch(s.charAt(i - 1), p.charAt(j - 2)));
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private boolean isCharMatch(char s, char p) {
        return p == '.' || s == p;
    }
}

class Solution010II {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 1; j < n; j += 2) {
            if (p.charAt(j) == '*') {
                dp[j + 1] = dp[j - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            boolean pre = dp[0];
            dp[0] = false;
            for (int j = 1; j <= n; j++) {
                boolean tmp = dp[j];
                if (p.charAt(j - 1) != '*') {
                    dp[j] = pre && isCharMatch(s.charAt(i - 1), p.charAt(j - 1));
                }
                else {
                    dp[j] = dp[j - 2] || dp[j] && isCharMatch(s.charAt(i - 1), p.charAt(j - 2));
                }
                pre = tmp;
            }
        }
        return dp[n];
    }

    private boolean isCharMatch(char s, char p) {
        return p == '.' || s == p;
    }
}

class Solution010III {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean first_match = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p)));
        }
        else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}