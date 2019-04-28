package JavaAnswer.three;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution220 {
    // In Java, -3 / 5 = 0 and but we need -3 / 5 = -1.
    private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }
        Map<Long, Long> map = new HashMap<>();
        long width = (long) t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long bucket = getID(nums[i], width);
            if (map.containsKey(bucket)) {
                return true;
            }
            if (map.containsKey(bucket - 1) && Math.abs(nums[i] - map.get(bucket - 1)) < width) {
                return true;
            }
            if (map.containsKey(bucket + 1) && Math.abs(nums[i] - map.get(bucket + 1)) < width) {
                return true;
            }
            map.put(bucket, (long) nums[i]);
            if (i >= k) {
                map.remove(getID(nums[i - k], width));
            }
        }
        return false;
    }
}

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (set.floor(n) != null && n <= t + set.floor(n) || set.ceiling(n) != null && set.ceiling(n) <= t + n) {
                return true;
            }
            set.add(n);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}