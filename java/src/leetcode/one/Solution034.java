package JavaAnswer.one;

public class Solution034 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };
        if (nums == null || nums.length == 0) {
            return result;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) { // right = mid
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        if (nums[right] != target) {
            return result;
        }
        result[0] = right;
        right = nums.length;
        while (left < right) { // right == mid
            int mid = (right - left) / 2 + left;
            if (nums[mid] <= target) { // only difference
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        result[1] = left - 1; // left > right
        return result;
    }
}