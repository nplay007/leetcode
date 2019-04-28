package interview;

public class SplitArray {
    public int splitArray(int X, int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == X) {
                left++;
            }
        }
        for (int i = length - 1; i >= 1; i--) {
            if (left == right) {
                return i;
            }
            if (nums[i] == X) {
                left--;
            }
            else {
                right++;
            }
        }
        return 0;
    }

    public int splitAarrayII(int X, int[] nums) {
        int sum = 0, seg = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == X) {
                sum++;
                seg++;
            }
            else {
                seg = 0;
            }
        }
        return (nums[n - 1] != X || sum > seg) ? (n - sum) : n;
    }
}
