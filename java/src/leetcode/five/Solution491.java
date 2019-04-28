package JavaAnswer.five;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        dfs(0, nums, ans, result);
        return new ArrayList<>(result);
    }

    public void dfs(int start, int[] nums, List<Integer> ans, Set<List<Integer>> result) {
        if (ans.size() >= 2) {
            result.add(new ArrayList<>(ans));
        }
        for (int i = start; i < nums.length; i++) {
            if (ans.size() == 0 || ans.get(ans.size() - 1) <= nums[i]) {
                ans.add(nums[i]);
                dfs(i + 1, nums, ans, result);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
