package JavaAnswer.seven;

public class Solution647 {
    private int count = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }
        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}

class Solution647II {
    public int countSubstrings(String S) {
        char[] words = new char[2 * S.length() + 3];
        words[0] = '@';
        words[1] = '#';
        words[words.length - 1] = '$';
        int j = 2;
        for (char ch : S.toCharArray()) {
            words[j++] = ch;
            words[j++] = '#';
        }

        int[] dp = new int[words.length];
        int center = 0, right = 0;
        for (int i = 1; i < dp.length - 1; ++i) {
            if (i < right) {
                dp[i] = Math.min(right - i, dp[2 * center - i]);
            }
            while (words[i + dp[i] + 1] == words[i - dp[i] - 1]) {
                dp[i]++;
            }
            if (i + dp[i] > right) {
                center = i;
                right = i + dp[i];
            }
        }
        int result = 0;
        for (int v : dp) {
            result += (v + 1) / 2;
        }
        return result;
    }
}
