package JavaAnswer.six;

import java.util.HashSet;
import java.util.Set;

public class Solution593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(distance(p1, p2));
        set.add(distance(p1, p3));
        set.add(distance(p1, p4));
        set.add(distance(p2, p3));
        set.add(distance(p2, p4));
        set.add(distance(p3, p4));
        return !set.contains(0) && set.size() == 2;
    }

    private int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
