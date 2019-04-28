package JavaAnswer.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < k) {
            return result;
        }
        List<Integer> ans = new ArrayList<>();
        dfs(0, k, n, ans, result);
        return result;
    }

    private void dfs(int start, int k, int n, List<Integer> ans, List<List<Integer>> result) {
        if (ans.size() == k) {
            result.add(new ArrayList<>(ans));
            return;
        }
        //start is the nums index
        for (int i = start; i < n; i++) {
            ans.add(i + 1);
            dfs(i + 1, k, n, ans, result);
            ans.remove(ans.size() - 1);
        }
    }
}

class Solution077Iterative {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        Integer[] ans = new Integer[k];
        Arrays.fill(ans, 0);
        while (i >= 0) {
            ans[i]++;
            if (ans[i] > n) {
                --i;
            }
            else if (i == k - 1) {
                result.add(new ArrayList<>(Arrays.asList(ans)));
            }
            else {
                ++i;
                ans[i] = ans[i - 1];
            }
        }
        return result;
    }
}

class Solution077II {
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0 || n == 0 || k > n) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(Arrays.asList(i));
        }
        for (int i = 2; i <= k; i++) {
            List<List<Integer>> next = new ArrayList<>();
            for (int j = i; j <= n; j++) {
                for (List<Integer> ans : result) {
                    if (ans.get(ans.size() - 1) < j) {
                        List<Integer> newComb = new ArrayList<>(ans);
                        newComb.add(j);
                        next.add(newComb);
                    }
                }
            }
            result = next;
        }
        return result;
    }
}