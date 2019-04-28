package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRepeats {
    public List<Integer> findRepeats(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.size() == k) {
                for (Integer key : map.keySet()) {
                    map.put(key, map.get(key) - 1);
                    if (map.get(key) == 0) {
                        map.remove(key);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                if (countMap.get(num) > nums.length / k) {
                    res.add(num);
                    map.remove(num);
                }
            }
        }
        return res;
    }
}
