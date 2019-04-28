package JavaAnswer.three;

public class Solution264 {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        // just care about number like 6, 10, 15
        for (int i = 1; i < n; i++) {
            int num = Math.min(2 * nums[idx2], Math.min(3 * nums[idx3], 5 * nums[idx5]));
            nums[i] = num;
            if (num == nums[idx2] * 2) {
                idx2++;
            }
            if (num == nums[idx3] * 3) {
                idx3++;
            }
            if (num == nums[idx5] * 5) {
                idx5++;
            }
        }
        return nums[n - 1];
    }
}