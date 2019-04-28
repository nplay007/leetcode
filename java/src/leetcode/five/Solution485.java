package JavaAnswer.five;

public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int current = 0, result = 0;
        for (int num : nums) {
            current = (num == 0) ? 0 : current + 1;
            result = Math.max(result, current);
        }
        return result;
    }
}
