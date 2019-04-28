package JavaAnswer.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution047Iterative {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<Integer>());
        for (int num : nums) {
            for (int size = result.size(); size > 0; size--) {
                List<Integer> ans = result.remove(0);
                for (int i = 0; i <= ans.size(); i++) {
                    if (i > 0 && ans.get(i - 1) == num) {
                        break;
                    }
                    List<Integer> nextPermute = new ArrayList<>(ans);
                    nextPermute.add(i, num);
                    result.add(nextPermute);
                }
            }
        }
        return result;
    }
}

class Solution047I {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] used = new boolean[nums.length];
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, used, ans, result);
        return result;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> ans, List<List<Integer>> result) {
        if (ans.size() == nums.length) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            ans.add(nums[i]);
            dfs(nums, used, ans, result);
            used[i] = false;
            ans.remove(ans.size() - 1);
        }
    }
}