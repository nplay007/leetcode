package JavaAnswer.three;

public class Solution276 {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        int diff = k * (k - 1);
        int same = k;
        // if different, diff = (diff + same) * ( k -1 )
        // if same, same = diff (only)
        for (int i = 2; i < n; i++) {
            int tmp = diff;
            diff = (diff + same) * (k - 1);
            same = tmp;
        }
        return diff + same;
    }
}