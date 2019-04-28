package JavaAnswer.three;

import java.util.ArrayList;
import java.util.List;

public class Solution254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(2, n, new ArrayList<>(), result);
        return result;
    }

    public void dfs(int i, int n, List<Integer> ans, List<List<Integer>> result) {
        for (; i * i <= n; i++) {
            if (n % i == 0) {
                ans.add(i);
                ans.add(n / i);
                result.add(new ArrayList<>(ans));
                ans.remove(ans.size() - 1);
                dfs(i, n / i, ans, result);
                ans.remove(ans.size() - 1);
            }
        }
    }
}