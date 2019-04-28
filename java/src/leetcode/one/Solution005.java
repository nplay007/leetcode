package JavaAnswer.one;

public class Solution005 {
    public String longestPalindrome(String s) {
        StringBuilder newStr = new StringBuilder("^");
        for (int i = 0; i < s.length(); i++) {
            newStr.append("#").append(s.charAt(i));
        }
        newStr.append("#$");
        int[] dp = new int[newStr.length()];
        int cidx = 0, ridx = 0, maxSpan = 0, maxIdx = 0;
        for (int i = 1; i < newStr.length() - 1; i++) {
            dp[i] = ridx > i ? Math.min(dp[2 * cidx - i], ridx - i) : 0;
            while (newStr.charAt(i + dp[i] + 1) == newStr.charAt(i - dp[i] - 1)) {
                dp[i]++;
            }
            if (i + dp[i] > ridx) {
                ridx = dp[i] + i;
                cidx = i;
            }
            if (dp[i] > maxSpan) {
                maxSpan = dp[i];
                maxIdx = i;
            }
        }
        return s.substring((maxIdx - maxSpan) / 2, (maxIdx + maxSpan) / 2);
    }
}

class Solution005II {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                int[] idx = getStartEnd(len, i);
                start = idx[0];
                end = idx[1];
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    private int[] getStartEnd(int len, int i) {
        if (len % 2 == 0) {
            return new int[] {i + 1 - len/2, i + len/2};
        }
        else {
            return new int[] {i - (len - 1)/2, i + (len - 1) / 2};
        }
    }
}