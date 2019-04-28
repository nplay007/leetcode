package JavaAnswer.six;

import java.util.Arrays;

public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}

class Solution516II {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int j = 1; j < n; j++) {
            int pre = dp[j];
            for (int i = j - 1; i >= 0; i--) {
                int tmp = dp[i];
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 <= j - 1) {
                        dp[i] = 2 + pre;
                    }
                    else {
                        dp[i] = 2;
                    }
                }
                else {
                    dp[i] = Math.max(dp[i + 1], dp[i]);
                }
                pre = tmp;
            }
        }
        return dp[0];
    }
}