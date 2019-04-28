package JavaAnswer.six;

public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxOfNum = nums[0], minOfNum = nums[nums.length - 1];
        int start = -1, end = -2;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            maxOfNum = Math.max(maxOfNum, nums[i]);
            minOfNum = Math.min(minOfNum, nums[n - i - 1]);
            if (maxOfNum > nums[i]) {
                end = i;
            }
            if (minOfNum < nums[n - i - 1]) {
                start = n - i - 1;
            }
        }
        return end - start + 1;
    }
}