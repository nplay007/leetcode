package JavaAnswer.four;

import java.util.Arrays;

public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int dp[] = new int[envelopes.length];
        int res = 0;
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, res, envelope[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = envelope[1];
            if (index == res) {
                res++;
            }
        }
        return res;
    }
}