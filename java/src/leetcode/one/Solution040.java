package JavaAnswer.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(0, target, new ArrayList<>(), candidates, result);
        return result;
    }

    private void combinationSum2(int start, int remain, List<Integer> ans, int[] candidates, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = start; i < candidates.length && remain >= candidates[i]; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            ans.add(candidates[i]);
            combinationSum2(i + 1, remain - candidates[i], ans, candidates, res);
            ans.remove(ans.size() - 1);
        }
    }
}