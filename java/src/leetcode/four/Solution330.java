package JavaAnswer.four;

public class Solution330 {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int result = 0;
        int i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            }
            else {
                miss += miss;
                result++;
            }
        }
        return result;
    }
}
