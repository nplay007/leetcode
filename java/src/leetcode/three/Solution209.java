package JavaAnswer.three;

public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, total = 0, result = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            while (total >= s) {
                result = Math.min(result, i - left + 1);
                total -= nums[left++];
            }
        }
        return result <= nums.length ? result : 0;
    }
}