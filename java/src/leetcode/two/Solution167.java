package JavaAnswer.two;

public class Solution167 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Invalid nums array");
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            }
            else if (nums[left] + nums[right] < target) {
                left++;
            }
            else {
                return new int[] { left + 1, right + 1 };
            }
        }
        throw new IllegalArgumentException("No answer!");
    }
}
