package JavaAnswer.two;

import java.util.ArrayList;
import java.util.List;

public class Solution163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        for (int num : nums) {
            if (num > lower) {
                result.add(lower + ((num - 1 > lower) ? "->" + (num - 1) : ""));
            }
            if (num == upper) {
                return result; // Avoid overflow
            }
            lower = num + 1;
        }
        if (lower <= upper) {
            result.add(lower + ((upper > lower) ? "->" + (upper) : ""));
        }
        return result;
    }
}