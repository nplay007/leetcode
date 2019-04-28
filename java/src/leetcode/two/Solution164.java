package JavaAnswer.two;

import java.util.Arrays;

public class Solution164 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int min = nums[0], max = nums[0];
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // the minimum possibale gap, ceiling of the integer division
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        // store the min value in that bucket
        int[] bucketsMIN = new int[nums.length - 1];
        // store the max value in that bucket
        int[] bucketsMAX = new int[nums.length - 1];
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num == min || num == max) {
                continue;
            }
            int idx = (num - min) / gap;
            bucketsMIN[idx] = Math.min(num, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(num, bucketsMAX[idx]);
        }
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE) {
                continue;
            }
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            previous = bucketsMAX[i];
        }
        // updata the final max value gap
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}