package JavaAnswer.five;

public class Solution477 {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int num : nums) {
                bitCount += (num >> i) & 1;
            }
            result += bitCount * (nums.length - bitCount);
        }
        return result;
    }
}