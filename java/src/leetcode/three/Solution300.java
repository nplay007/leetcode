package JavaAnswer.three;

import java.util.Arrays;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length]; //index of LIS
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            len = Math.max(len, i + 1); // start from 0
        }
        return len;
    }
}

class Solution300DP {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
