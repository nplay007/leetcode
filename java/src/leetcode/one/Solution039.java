package JavaAnswer.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(0, target, new ArrayList<>(), candidates, result);
        return result;
    }

    private void combinationSum(int start, int remain, List<Integer> ans, int[] candidates, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = start; i < candidates.length && remain >= candidates[i]; i++) {
            ans.add(candidates[i]);
            combinationSum(i, remain - candidates[i], ans, candidates, result);
            ans.remove(ans.size() - 1);
        }
    }
}

class Solution039Iterative {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            List<List<Integer>> result = new ArrayList<>();
            // run through all candidates <= i
            for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
                // special case when target is equal to the candidate
                if (i == candidates[j]) {
                    result.add(Arrays.asList(candidates[j]));
                }
                // if current candidate is less than the target use previous saved results
                else {
                    for (List<Integer> prev : dp.get(i - candidates[j] - 1)) {
                        if (candidates[j] <= prev.get(0)) { // avoid duplicate for example 5
                            List<Integer> ans = new ArrayList<>();
                            ans.add(candidates[j]);
                            ans.addAll(prev);
                            result.add(ans);
                        }
                    }
                }
            }
            dp.add(result);
        }
        return dp.get(target - 1);
    }
}