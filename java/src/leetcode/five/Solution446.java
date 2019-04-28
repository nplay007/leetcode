package JavaAnswer.five;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution446 {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        List<Map<Integer, Integer>> map = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            map.add(new HashMap<>());
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }
                int d = (int) diff;
                int c1 = map.get(i).getOrDefault(d, 0);
                int c2 = map.get(j).getOrDefault(d, 0);
                res += c2;
                map.get(i).put(d, c1 + c2 + 1);
            }
        }
        return res;
    }
}
