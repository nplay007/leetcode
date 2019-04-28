package JavaAnswer.four;

class NumArrayII {
    int[] nums;
    int[] bit;
    int n;

    public NumArrayII(int[] nums) {
        this.nums = nums;
        n = nums.length;
        bit = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]); // start from 1 not 0
        }
    }

    public void add(int i, int val) {
        while (i <= n) {
            bit[i] += val;
            i += (i & -i);
        }
    }

    void update(int i, int val) {
        add(i + 1, val - nums[i]); //add the difference to i+1
        nums[i] = val; // update nums[i]
    }

    public int getSum(int i) {
        if (nums == null) {
            return 0;
        }
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= (i & -i);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return getSum(j + 1) - getSum(i);
    }
}