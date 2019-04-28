package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Sub-array Sum
// 只需要判断是否存在，返回boolean

public class SubArraySum {
    public boolean subArraySum(int[] nums, int k) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            sum += num;
            if (sum == k || set.contains(sum - k)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }
}

// Minimum Size Subarray Sum
// Two pointer
class minimumSubArraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0, min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

// Maximum Size Subarray Sum Equals k
class MaximumSubArraySum {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                max = i + 1;
            }
            else if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }
}

// 这两道题的解法完全不同：这道题由于是求“equal”，所以用“hash”；上一题是求“大于等于”，所以是用two pointers尺取法。
// 而且由于两道题的要求不同，它们的输入数据也不同：这道题的输入数据可正可负；上一题却只能是非负数。

class subarraySumSize {
    // output the number of subarray Sum equals to k
    public static int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        // make use of the sum_list
        // the key is the sum at index i, value is the accumulated # that could get to k
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
