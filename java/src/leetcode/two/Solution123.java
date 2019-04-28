package JavaAnswer.two;

public class Solution123 {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        // Assume we only have 0 money at first
        for (int price : prices) {
            // The maximum if we've just sold 2nd stock so far.
            release2 = Math.max(release2, hold2 + price);
            // The maximum if we've just buy 2nd stock so far.
            hold2 = Math.max(hold2, release1 - price);
            // The maximum if we've just sold 1nd stock so far.
            release1 = Math.max(release1, hold1 + price);
            // The maximum if we've just buy 1st stock so far.
            hold1 = Math.max(hold1, -price);
        }
        return release2;
        /// release1 is initiated as 0, so release2 will always higher than release1.
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        // f[k, i] represents the max profit up until prices[i] (NOT ending with prices[i]) using at most k transactions.
        // f[k, i] = max(f[k, i-1], prices[i] - prices[j] + f[k-1, j]) { j in range of [0, i-1] }
        // = max(f[k, i-1], prices[i] + max(f[k-1, j] - prices[j]))
        // f[0, i] = 0; 0 times transaction makes 0 profit
        // f[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int numOfTransaction = 2; // number of max transation allowed
        int maxProf = 0;
        int[][] dp = new int[numOfTransaction + 1][prices.length];
        for (int i = 1; i <= numOfTransaction; i++) {
            int tmpMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, dp[i - 1][j] - prices[j]);
                maxProf = Math.max(dp[i][j], maxProf);
            }
        }
        return maxProf;
    }
}