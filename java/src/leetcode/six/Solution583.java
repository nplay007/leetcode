package JavaAnswer.six;

public class Solution583 {
    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * lcs(word1, word2);
    }

    private int lcs(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
            }
        }
        return dp[m][n];
    }
}

class Solution583II {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                }
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }

            }
        }
        return dp[m][n];
    }
}

class Solution5831D {
    public int minDistance(String s1, String s2) {
        int[] dp = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int[] temp = new int[s2.length() + 1];
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    temp[j] = i + j;
                }
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    temp[j] = dp[j - 1];
                }
                else {
                    temp[j] = 1 + Math.min(dp[j], temp[j - 1]);
                }
            }
            dp = temp;
        }
        return dp[s2.length()];
    }
}