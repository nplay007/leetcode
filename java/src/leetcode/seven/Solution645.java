package JavaAnswer.seven;

public class Solution645 {
    public int[] findErrorNums(int[] nums) {
        int dup = -1, miss = 1;
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                dup = Math.abs(num);
            }
            else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                miss = i + 1; // 1 to n
            }
        }
        return new int[] { dup, miss };
    }
}
