package JavaAnswer.one;

public class Solution072 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            int pre = dp[0]; // pre = dp[i-1][j-1]
            dp[0] = i; // dp[i][0] = i
            for (int j = 1; j <= n; j++) {
                int tmp = dp[j]; // save dp[i-1][j-1]
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = pre;
                }
                else {
                    dp[j] = Math.min(pre, Math.min(dp[j - 1], dp[j])) + 1;
                }
                pre = tmp;
            }
        }
        return dp[n];
    }
}

class Solution072Two {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}