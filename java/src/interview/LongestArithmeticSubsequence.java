package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestArithmeticSubsequence {
    public static List<Integer> longestArith(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int[][] dp = new int[nums.length][nums.length];
        int maxLen = 0;
        int step = -1;
        int lastElement = -1;

        for (int i = 1; i < nums.length - 1; i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < nums.length) {
                if (nums[left] + nums[right] > nums[i] * 2) {
                    left--;
                }
                else if (nums[left] + nums[right] < nums[i] * 2) {
                    right++;
                }
                else {
                    dp[i][right] = dp[left][i] == 0 ? 3 : dp[left][i] + 1;
                    if (dp[i][right] > maxLen) {
                        maxLen = dp[i][right];
                        lastElement = nums[right];
                        step = nums[i] - nums[left];
                    }
                    left--;
                    right++;
                }
            }
        }
        for (int i = 0; i < maxLen; i++) {
            result.add(lastElement);
            lastElement -= step;
        }
        return result;
    }
}
