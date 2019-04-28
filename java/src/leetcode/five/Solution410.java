package JavaAnswer.five;

public class Solution410 {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        int[] sub = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return dp[n][m];
    }
}

class Solution410BS {
    public int splitArray(int[] nums, int m) {
        int maxOfArray = 0;
        long sumOfArray = 0;
        for (int num : nums) {
            maxOfArray = Math.max(num, maxOfArray);
            sumOfArray += num;
        }
        if (m == 1) {
            return (int) sumOfArray;
        }
        long left = maxOfArray, right = sumOfArray;
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            if (valid(mid, nums, m)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    // divide into m sub-array with sum less than target
    public boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for (int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}