package JavaAnswer.four;

import java.util.HashSet;
import java.util.Set;

public class Solution391 {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) {
            return false;
        }
        int x1 = Integer.MAX_VALUE, x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE, y2 = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        int area = 0;
        for (int[] rect : rectangles) {
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            // four points of rectangles
            String s1 = rect[0] + " " + rect[1];
            String s2 = rect[0] + " " + rect[3];
            String s3 = rect[2] + " " + rect[3];
            String s4 = rect[2] + " " + rect[1];
            if (set.contains(s1)) {
                set.remove(s1);
            }
            else {
                set.add(s1);
            }
            if (set.contains(s2)) {
                set.remove(s2);
            }
            else {
                set.add(s2);
            }
            if (set.contains(s3)) {
                set.remove(s3);
            }
            else {
                set.add(s3);
            }
            if (set.contains(s4)) {
                set.remove(s4);
            }
            else {
                set.add(s4);
            }
        }
        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2)
                || set.size() != 4) {
            return false;
        }
        return area == (x2 - x1) * (y2 - y1);
    }
}