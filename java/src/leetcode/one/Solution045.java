package JavaAnswer.one;

public class Solution045 {
    public int jump(int[] nums) {
        int step = 0, reachable = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reachable < i) {
                step++;
                reachable = cur;
            }
            cur = Math.max(cur, nums[i] + i);
        }
        return step;
    }
}