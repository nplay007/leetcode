package JavaAnswer.six;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// <sum, count>
// sum: cumulative sum of the bricks' widths encountered in the current row
// sum represents the positions of the bricks's boundaries relative to the leftmost boundary.
// count: number of times the corresponding sum is obtained.

public class Solution554 {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int maxCount = 0;
        for (int key : map.keySet()) {
            maxCount = Math.max(map.get(key), maxCount);
        }
        return wall.size() - maxCount;
    }
}