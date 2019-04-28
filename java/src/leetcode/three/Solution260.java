package JavaAnswer.three;

public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        int mask = 1;
        while (mask != (res & mask)) {
            mask <<= 1;
        }
        int[] ans = new int[2];
        for (int num : nums) {
            if ((num & mask) != 0) {
                ans[0] ^= num;
            }
        }
        ans[1] = ans[0] ^ res;
        return ans;
    }
}