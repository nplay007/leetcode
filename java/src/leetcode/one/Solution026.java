package JavaAnswer.one;

public class Solution026 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int last = 0;
        for (int num : nums) {
            if (num != nums[last]) {
                nums[++last] = num;
            }
        }
        return last + 1;
    }
}