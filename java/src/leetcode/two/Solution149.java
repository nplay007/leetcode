package JavaAnswer.two;

import java.util.HashMap;
import java.util.Map;

import JavaAnswer.Point;

public class Solution149 {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        else if (points.length <= 2) {
            return points.length;
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int overlap = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }

                if (map.containsKey(x)) {
                    map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1);
                }
                else {
                    map.put(x, new HashMap<>());
                    map.get(x).put(y, 1);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }

    private int generateGCD(int a, int b) {
        return (b == 0) ? a : generateGCD(b, a % b);
    }
}
