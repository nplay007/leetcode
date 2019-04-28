package JavaAnswer.six;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> res = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        int sum;
        for (int j = 0; j < list2.length && j <= minSum; j++) {
            if (map.containsKey(list2[j])) {
                sum = j + map.get(list2[j]);
                if (sum < minSum) {
                    res.clear();
                    res.add(list2[j]);
                    minSum = sum;
                }
                else if (sum == minSum) {
                    res.add(list2[j]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
