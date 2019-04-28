package JavaAnswer.two;

public class Solution115 {
    public int numDistinct(String S, String T) {
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i <= S.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                dp[i][j] = dp[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[S.length()][T.length()];
    }
}

class Solution115II {
    public int numDistinct(String S, String T) {
        int[] dp = new int[T.length() + 1];
        for (int i = 1; i <= S.length(); i++) {
            int pre = 1;
            for (int j = 1; j <= T.length(); j++) {
                int tmp = dp[j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[j] += pre;
                }
                pre = tmp;
            }
        }
        return dp[T.length()];
    }
}