package JavaAnswer.four;

import java.util.Random;

public class Solution384 {
    private int[] nums;
    private Random random;

    public Solution384(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        if (nums == null) {
            return null;
        }
        int[] clone = nums.clone();
        for (int j = clone.length - 1; j >= 0; j--) {
            int i = random.nextInt(j + 1);
            int tmp = clone[i];
            clone[i] = clone[j];
            clone[j] = tmp;
        }
        return clone;
    }
}
