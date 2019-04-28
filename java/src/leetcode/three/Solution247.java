package JavaAnswer.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution247 {
    public List<String> findStrobogrammatic(int n) {
        return dfs(n, n);
    }

    List<String> dfs(int n, int m) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        else if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }
        List<String> list = dfs(n - 2, m);
        List<String> res = new ArrayList<>();
        for (String s : list) {
            if (n != m) {
                res.add("0" + s + "0");
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}