package JavaAnswer.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(0, nums, ans, result);
        return result;
    }

    public void dfs(int start, int[] nums, List<Integer> ans, List<List<Integer>> res) {
        res.add(new ArrayList<>(ans));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            ans.add(nums[i]);
            dfs(i + 1, nums, ans, res);
            ans.remove(ans.size() - 1);
        }
    }
}

class Solution090Iterative {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int size = 0, start = 0;
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            start = (i > 0 && nums[i] == nums[i - 1]) ? size : 0;
            size = result.size();
            for (int j = start; j < size; j++) {
                List<Integer> subset = new ArrayList<>(result.get(j));
                subset.add(nums[i]);
                result.add(subset);
            }
        }
        return result;
    }
}