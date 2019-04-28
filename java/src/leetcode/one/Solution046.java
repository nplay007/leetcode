package JavaAnswer.one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution046 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());
        for (int num : nums) {
            for (int size = result.size(); size > 0; size--) {
                List<Integer> ans = result.remove(0);
                for (int i = 0; i <= ans.size(); i++) {
                    List<Integer> nextPermute = new LinkedList<>(ans);
                    nextPermute.add(i, num);
                    result.add(nextPermute);
                }
            }
        }
        return result;
    }
}

class Solution046Recrusion {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        permute(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void permute(int start, int[] nums, List<Integer> ans, List<List<Integer>> result) {
        if (ans.size() == nums.length) {
            result.add(ans);
            return;
        }
        for (int i = 0; i <= ans.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(ans);
            newPermutation.add(i, nums[start]);
            permute(start + 1, nums, newPermutation, result);
        }
    }
}

class Solution046Swap {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(0, nums, res);
        return res;
    }

    private void dfs(int start, int[] nums, List<List<Integer>> res) {
        if (start == nums.length) {
            List<Integer> ans = new ArrayList<>();
            for (int num : nums) {
                ans.add(num);
            }
            res.add(ans);
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            swap(nums, start, i);
            dfs(start + 1, nums, res);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}