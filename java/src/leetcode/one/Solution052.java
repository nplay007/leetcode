package JavaAnswer.one;

import java.util.Arrays;

public class Solution052 {
    private int[] col;
    private int count;

    public int totalNQueens(int n) {
        count = 0;
        col = new int[n];
        Arrays.fill(col, -1);
        dfs(0, n);
        return count;
    }

    private void dfs(int start, int n) {
        if (start == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(start, i)) {
                col[start] = i;
                dfs(start + 1, n);
                col[start] = -1;
            }
        }
    }

    private boolean check(int i, int j) {
        for (int k = 0; k < i; k++) {
            if (col[k] == j || Math.abs(k - i) == Math.abs(j - col[k])) {
                return false;
            }
        }
        return true;
    }
}