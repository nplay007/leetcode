package JavaAnswer.five;

public class Solution487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, idx = -1;
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0) {
                l = idx + 1;
                idx = h;
            }
            res = Math.max(res, h - l + 1);
        }
        return res;
    }
}
