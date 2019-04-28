package JavaAnswer.three;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(1, n, k, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void combination(int start, int target, int k, List<Integer> ans, List<List<Integer>> res) {
        if (ans.size() == k && target == 0) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int i = start; i <= 9; i++) {
            ans.add(i);
            combination(i + 1, target - i, k, ans, res);
            ans.remove(ans.size() - 1);
        }
    }
}