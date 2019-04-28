package JavaAnswer.four;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    List<Integer> nums; // list of nums
    Map<Integer, Integer> map; // num : index
    Random random;

    public RandomizedSet() {
        nums = new LinkedList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        if (idx < nums.size() - 1) {
            int numOfLast = nums.get(nums.size() - 1); // num at last
            nums.set(idx, numOfLast);
            map.put(numOfLast, idx);
        }
        map.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
