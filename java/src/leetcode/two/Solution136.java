package JavaAnswer.two;

import java.util.List;

public class Solution136 {
    public int singleNumber(List<Integer> nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}