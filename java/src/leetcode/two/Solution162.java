package JavaAnswer.two;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) { // one element
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            else { // nums[mid] == nums[mid + 1]
                right = mid;
            }
        }
        return right;
    }
}