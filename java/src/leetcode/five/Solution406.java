package JavaAnswer.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        // large height or small index appear first
        Arrays.sort(people, (p1, p2) -> (p1[0] != p2[0] ? p2[0] - p1[0] : p1[1] - p2[1]));
        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][]);
    }
}