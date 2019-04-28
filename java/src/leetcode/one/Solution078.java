package JavaAnswer.one;

import java.util.ArrayList;
import java.util.List;

public class Solution078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        subsets(0, nums, ans, result);
        return result;
    }

    private void subsets(int start, int[] nums, List<Integer> ans, List<List<Integer>> result) {
        result.add(new ArrayList<>(ans));
        // add number at start to subsets
        for (int i = start; i < nums.length; i++) {
            ans.add(nums[i]);
            subsets(i + 1, nums, ans, result);
            ans.remove(ans.size() - 1); // remove
        }
    }
}

class Solution078Iterative {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            int size = result.size();
            for (int j = 0; j < size; ++j) {
                // create a new list
                List<Integer> subset = new ArrayList<>(result.get(j));
                subset.add(num);
                result.add(subset);
            }
        }
        return result;
    }
}