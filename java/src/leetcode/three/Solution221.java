package JavaAnswer.three;

public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, result = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                    result = Math.max(dp[i][j], result);
                }
            }
        }
        return result * result;
    }
}

class Solution2211DP {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
        int[] dp = new int[n + 1];
        int result = 0, pre = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int tmp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], pre), dp[j]) + 1;
                    result = Math.max(result, dp[j]);
                }
                else {
                    dp[j] = 0;
                }
                pre = tmp;
            }
        }
        return result * result;
    }
}
