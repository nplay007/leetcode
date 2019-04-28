package JavaAnswer.one;

public class Solution091 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1; // dp[1] = dp[0];
        for (int i = 1; i <= s.length(); i++) { // i = 2 is special case
            if (s.charAt(i - 1) <= '9' && s.charAt(i - 1) >= '1') {
                dp[i] = dp[i - 1];
            }
            if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7'))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}

class Solution091II {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int pre = 0; // dp[0]
        int cur = 1; // dp[1] default is 1, "0" is updated later
        for (int i = 1; i <= s.length(); i++) {
            int tmp = cur;
            if (s.charAt(i - 1) > '9' || s.charAt(i - 1) < '1') {
                cur = 0;
            }
            if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7'))) {
                cur += pre;
            }
            pre = tmp;
        }
        return cur;
    }
}