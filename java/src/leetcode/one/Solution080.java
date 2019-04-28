package JavaAnswer.one;

public class Solution080 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 3) {
            return nums == null ? 0 : nums.length;
        }
        int last = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[last - 2]) {
                nums[last++] = nums[i];
            }
        }
        return last;
    }
}