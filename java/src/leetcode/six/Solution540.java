package JavaAnswer.six;

public class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length, left = 0, right = n / 2;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[2 * mid] != nums[2 * mid + 1]) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return nums[2 * left];
    }
}
