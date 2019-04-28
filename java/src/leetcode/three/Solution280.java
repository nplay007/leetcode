package JavaAnswer.three;

public class Solution280 {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i + 1]) || (i % 2 == 1 && nums[i] < nums[i + 1])) {
                int tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            }
        }
    }
}