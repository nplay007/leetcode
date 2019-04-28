package JavaAnswer.one;

import java.util.ArrayList;
import java.util.List;

public class Solution089 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int m = 1 << n;
        for (int i = 0; i < m; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}