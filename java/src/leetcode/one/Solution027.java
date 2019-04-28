package JavaAnswer.one;

public class Solution027 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[last++] = nums[i];
            }
        }
        return last;
    }
}