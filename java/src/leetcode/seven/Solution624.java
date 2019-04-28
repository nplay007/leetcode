package JavaAnswer.seven;

import java.util.List;

public class Solution624 {
    public int maxDistance(List<List<Integer>> list) {
        int res = 0, min_val = list.get(0).get(0), max_val = list.get(0).get(list.get(0).size() - 1);
        for (int i = 1; i < list.size(); i++) {
            res = Math.max(res, Math.max(Math.abs(list.get(i).get(list.get(i).size() - 1) - min_val), Math.abs(max_val - list.get(i).get(0))));
            min_val = Math.min(min_val, list.get(i).get(0));
            max_val = Math.max(max_val, list.get(i).get(list.get(i).size() - 1));
        }
        return res;
    }
}
