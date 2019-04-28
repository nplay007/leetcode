package JavaAnswer.five;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution403 {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return true;
        }
        // start location : set of locations can reach
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(1);
        for (int stone : stones) {
            for (int step : map.get(stone)) {
                int reach = step + stone;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }
                Set<Integer> next = map.get(reach);
                if (next != null) {
                    next.add(step);
                    if (step - 1 > 0) {
                        next.add(step - 1);
                    }
                    next.add(step + 1);
                }
            }
        }
        return false;
    }
}