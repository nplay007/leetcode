package JavaAnswer.four;

import java.util.HashMap;
import java.util.Map;

public class Solution325 {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                result = i + 1;
            }
            else if (map.containsKey(sum - k)) {
                result = Math.max(result, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return result;
    }
}

class Solution325II {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int sum = 0;
        map.put(0, -1); // fake entry to make sum consistent as the longest from 0 to i
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                result = Math.max(result, i - map.get(sum - k));
            }
            // only recording first occurance to make it max
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return result;
    }
}