package JavaAnswer.four;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class RandomizedCollection {
    List<Integer> nums;
    Map<Integer, Set<Integer>> map;
    Random random;

    public RandomizedCollection() {
        nums = new LinkedList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) {
            map.put(val, new LinkedHashSet<Integer>());
        }
        map.get(val).add(nums.size());
        nums.add(val);
        return !contain;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val).iterator().next();
        map.get(val).remove(idx);
        if (idx < nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(idx, last);
            map.get(last).remove(nums.size() - 1);
            map.get(last).add(idx);
        }
        nums.remove(nums.size() - 1);
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}