package JavaAnswer.four;

import java.util.Random;

class Solution398 {
    private int[] nums;
    private Random random;

    public Solution398(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int next = random.nextInt(++count);
                if (next == 0) {
                    result = i;
                }
            }
        }
        return result;
    }
}
