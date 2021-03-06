package JavaAnswer.one;

public class Solution075 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; ) {
            if (nums[i] == 0) {
                swap(nums, left++, i++);
            }
            else if (nums[i] == 2) {
                swap(nums, right--, i);
            }
            else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}