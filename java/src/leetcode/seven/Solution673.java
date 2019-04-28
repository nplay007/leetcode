package JavaAnswer.seven;

import java.util.Arrays;

public class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] lengths = new int[nums.length];
        int[] counts = new int[nums.length];
        Arrays.fill(counts, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lengths[j] >= lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    }
                    else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
        }
        int longest = 0;
        int result = 0;
        for (int length : lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < nums.length; ++i) {
            if (lengths[i] == longest) {
                result += counts[i];
            }
        }
        return result;
    }
}