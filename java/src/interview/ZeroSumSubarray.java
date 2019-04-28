package interview;

import java.util.Set;
import java.util.HashSet;

public class ZeroSumSubarray {
    // Function to check if sub-array with 0 sum is present in the given array or not
    public static Boolean zeroSumSubarray(int nums[]) {
        // create an empty set to store sum of elements of each
        // sub-array A[0..i] where 0 <= i < arr.length
        Set<Integer> set = new HashSet<>();

        // insert 0 into set to handle the case when sub-array with
        // 0 sum starts from index 0
        set.add(0);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            // if sum is seen before, we have found a sub-array with 0 sum
            if (!set.add(sum)) {
                return true;
            }
        }
        return false;
    }
}
