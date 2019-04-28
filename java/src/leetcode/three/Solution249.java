package JavaAnswer.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution249 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String key = "";
            for (char ch : str.toCharArray()) {
                key += (char) ((ch - str.charAt(0) + 26) % 26 + 'a');
            }
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}