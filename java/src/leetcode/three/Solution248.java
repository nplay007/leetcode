package JavaAnswer.three;

public class Solution248 {
    private int count;

    public int strobogrammaticInRange(String low, String high) {
        count = 0;
        dfs(low, high, "");
        dfs(low, high, "0");
        dfs(low, high, "1");
        dfs(low, high, "8");
        return count;
    }

    private void dfs(String low, String high, String word) {
        int l = low.length(), h = high.length(), w = word.length();
        if (l <= w && w <= h) {
            if ((l == w && word.compareTo(low) < 0) || (w == h && word.compareTo(high) > 0)) {
                return;
            }
            if (!(w > 1 && word.charAt(0) == '0')) {
                count++;
            }
        }
        if (w + 2 > h) {
            return;
        }
        dfs(low, high, "0" + word + "0");
        dfs(low, high, "1" + word + "1");
        dfs(low, high, "6" + word + "9");
        dfs(low, high, "8" + word + "8");
        dfs(low, high, "9" + word + "6");
    }
}
