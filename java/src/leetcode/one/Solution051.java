package JavaAnswer.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution051 {
    private int[] col;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        col = new int[n];
        Arrays.fill(col, -1);
        dfs(0, n, new ArrayList<String>(), res);
        return res;
    }

    private void dfs(int start, int n, List<String> ans, List<List<String>> res) {
        if (start == n) {
            res.add(new ArrayList<String>(ans));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(start, i)) {
                col[start] = i;
                char[] charArray = new char[n];
                Arrays.fill(charArray, '.');
                charArray[i] = 'Q';
                String rowString = new String(charArray);
                ans.add(rowString);
                dfs(start + 1, n, ans, res);
                ans.remove(ans.size() - 1);
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