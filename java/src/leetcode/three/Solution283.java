package JavaAnswer.three;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int noneZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[noneZeroIndex];
                nums[noneZeroIndex++] = tmp;
            }
        }
    }
}