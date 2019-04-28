package JavaAnswer.three;

public class Solution274 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int[] dp = new int[n + 1];
        for (int citation : citations) {
            if (citation >= n) {
                dp[n]++;
            }
            else {
                dp[citation]++;
            }
        }
        int cites = 0;
        for (int i = citations.length; i >= 0; i--) {
            cites += dp[i];
            if (cites >= i) {
                return i; // papers
            }
        }
        return 0;
    }
}