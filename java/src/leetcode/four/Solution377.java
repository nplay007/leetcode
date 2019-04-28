package JavaAnswer.four;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                }
                else if (num == i) {
                    dp[i] += 1;
                }
                else {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}

class Solution377II {
    Map<Integer, Integer> map = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length == 0 || target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        for (int num : nums) {
            count += combinationSum4(nums, target - num);
        }
        map.put(target, count);
        return count;
    }
}