package JavaAnswer;

public class BIT {
    private int[] dp;
    private int[] nums;
    private int size;

    public BIT(int[] nums) {
        size = nums.length;
        dp = new int[size + 1];
        this.nums = nums;
        for (int i = 0; i < size; i++) {
            add(i + 1, nums[i]);
        }
    }

    private void add(int x, int val) {
        while (x <= size) {
            dp[x] += val;
            x += lowbit(x);
        }
    }

    private int lowbit(int x) {
        return x & -x;
    }

    private int sum(int x) {
        int res = 0;
        while (x > 0) {
            res += dp[x];
            x -= lowbit(x);
        }
        return res;
    }

    public void update(int i, int val) {
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        if (nums == null) {
            return 0;
        }
        return sum(j + 1) - sum(i);
    }
}
