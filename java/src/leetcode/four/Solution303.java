package JavaAnswer.four;

class NumArray {
    private int[] sum;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        sum = new int[nums.length + 1];
        sum[0] = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if (sum == null) {
            return 0;
        }
        return sum[j + 1] - sum[i];
    }
}