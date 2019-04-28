package JavaAnswer.five;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// subset sum + DP
// Find a subset of nums that need to be positive and the rest of them negative such that the sum is equal to target.
// Let P be the positive subset and N be the negative subset
// sum(P) - sum(N) = target
// sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
//     2 * sum(P) = target + sum(nums)
// So the original problem has been converted to a subset sum problem as follows:
// Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2.
// Note that the above formula has proved that target + sum(nums) must be even,
// We can use that fact to quickly identify inputs that do not have a solution

class Solution494DP {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) / 2);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = s; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[s];
    }
}

// DFS + memoization
// 先找到第一步的所有可能，在每种第一步的可能下再试遍第二步的所有可能,以这种方式试遍所有的组合。但是如果中途发现某一个组合肯定没前途，则立刻放弃这个组合（Backtrack）。
// 此题和Combination sum完全不同
// combination sum是每次在数组空间内选择一个数使得最终sum = target，而此题是每次对当前位置的数选择 + 或 -，最终目标是给每个数都赋予符号并使sum = target

class Solution494DFS {
    public int findTargetSumWays(int[] nums, int S) {
        Map<String, Integer> map = new HashMap<>();
        return dfs(nums, S, 0, map);
    }

    private int dfs(int[] nums, int sum, int i, Map<String, Integer> map) {
        String key = i + ": " + sum;
        if (map.containsKey(key))
            return map.get(key);
        if (i == nums.length)
            return sum == 0 ? 1 : 0;
        int add = dfs(nums, sum - nums[i], i + 1, map);
        int minus = dfs(nums, sum + nums[i], i + 1, map);
        map.put(key, add + minus);
        return add + minus;
    }
}

class Solution494Recursion {
    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        calculate(0, nums, 0, S);
        return count;
    }

    public void calculate(int i, int[] nums, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) {
                count++;
            }
        }
        else {
            calculate(i + 1, nums, sum + nums[i], S);
            calculate(i + 1, nums, sum - nums[i], S);
        }
    }
}

class Solution494RM {
    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calculate(nums, 0, 0, S, memo);
    }

    public int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
        if (i == nums.length) {
            return sum == S ? 1 : 0;
        }
        else {
            if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
                return memo[i][sum + 1000];
            }
            int add = calculate(nums, i + 1, sum + nums[i], S, memo);
            int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
            memo[i][sum + 1000] = add + subtract;
            return memo[i][sum + 1000];
        }
    }
}

public class Solution494 {
    public int findTargetSumWays(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return S > 1000 ? 0 : dp[S + 1000];
    }
}
