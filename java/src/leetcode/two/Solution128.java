package JavaAnswer.two;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        // keep track of the length of two size of consecutive numbers
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int sum = left + right + 1;
                result = Math.max(result, sum);
                map.put(num, sum);
                map.put(num - left, sum);
                map.put(num + right, sum);
                // map.remove(num - 1);
                // map.remove(num + 1);
            }
        }
        return result;
    }
}


class Solution128Set {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                continue;
            }
            set.remove(num);
            int left = num - 1, right = num + 1;
            while (set.contains(left)) {
                set.remove(left--);
            }
            while (set.contains(right)) {
                set.remove(right++);
            }
            res = Math.max(res, right - left -1);
        }
        return res;
    }
}