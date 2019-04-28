package JavaAnswer.two;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    Map<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num1 = entry.getKey(), num2 = value - num1;
            if ((num1 == num2 && entry.getValue() > 1) || (num1 != num2 && map.containsKey(num2))) {
                return true;
            }
        }
        return false;
    }
}