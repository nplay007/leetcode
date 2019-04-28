package JavaAnswer.six;

public class Solution598 {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(m, op[0]); // at least m times in row
            n = Math.min(n, op[1]); // at least n times in column
        }
        return m * n;
    }
}
