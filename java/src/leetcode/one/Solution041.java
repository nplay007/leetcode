package JavaAnswer.one;

public class Solution041 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // idx = nums[i] - 1, 0 <= idx <= nums.length - 1
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp; // nums[i] has been changed
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1; //value not index
            }
        }
        return nums.length + 1;
    }
}