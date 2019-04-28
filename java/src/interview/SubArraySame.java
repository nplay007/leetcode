package interview;

public class SubArraySame {
    // Partition problem is to determine whether a given set can be partitioned into two subsets
    // such that the sum of elements in both subsets is same.
    // http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
    public boolean recursive(int[] nums, int n, int target) {
        if (target == 0) {
            return true;
        }
        if (n == 0 && target != 0) {
            return false;
        }
        if (nums[n - 1] > target) {
            return recursive(nums, n - 1, target);
        }
        return recursive(nums, n - 1, target) || recursive(nums, n - 1, target - nums[n - 1]);
    }

    public boolean findPartion(int[] nums, int n) {
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        if (target % 2 != 0) {
            return false;
        }
        return recursive(nums, n, target / 2);
    }

    public boolean dynamicProgram(int[] nums) {
        int n = nums.length, target = 0;
        for (int num : nums) {
            target += num;
        }
        if (target % 2 != 0) {
            return false;
        }
        boolean[][] dp = new boolean[target / 2 + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i < target / 2 + 1; i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i < target / 2 + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i >= nums[j - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - nums[j - 1]][j - 1];
                }
            }
        }
        return dp[target / 2][n];
    }
}
