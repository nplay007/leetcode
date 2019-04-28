package JavaAnswer.five;

import java.util.ArrayList;
import java.util.List;

public class Solution442 {
    // when find a number i, flip the number at position i-1 to negative.
    // if nums[i-1] is already negative, nums[i] is the number that occurs twice.
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(nums[i]));
            }
            nums[index] = -nums[index];
        }
        return res;
    }
}
