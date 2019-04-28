package JavaAnswer.four;

import java.util.*;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int idx1 = 0, idx2 = 0;
        List<Integer> intersection = new ArrayList<>();
        while ((idx1 < nums1.length) && (idx2 < nums2.length)) {
            if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            }
            else if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            }
            else {
                intersection.add(nums1[idx1]);
                idx1++;
                idx2++;
            }
        }
        int[] res = new int[intersection.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = intersection.get(i);
        }
        return res;
    }
}

class Solution350II {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> intersection = new LinkedList<>();
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                intersection.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] res = new int[intersection.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = intersection.get(i);
        }
        return res;
    }
}

