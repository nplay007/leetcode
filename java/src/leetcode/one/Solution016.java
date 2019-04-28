package JavaAnswer.one;

import java.util.Arrays;

public class Solution016 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("Invalid nums array");
        }
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (diff > Math.abs(target - sum)) {
                    diff = Math.abs(target - sum);
                    result = sum;
                }
                if (sum == target) {
                    return target;
                }
                else if (sum > target) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return result;
    }
}