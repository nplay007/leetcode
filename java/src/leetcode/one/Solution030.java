package JavaAnswer.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution030 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        int m = words.length, n = words[0].length();
        Map<String, Integer> wordsMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            wordsMap.put(words[i], wordsMap.getOrDefault(words[i], 0) + 1);
        }
        for (int i = 0; i <= s.length() - m * n; i++) {
            int j = 0;
            Map<String, Integer> sMap = new HashMap<>();
            for (; j < m; j++) {
                String str = s.substring(i + j * n, i + (j + 1) * n);
                if (!wordsMap.containsKey(str)) {
                    break;
                }
                sMap.put(str, sMap.getOrDefault(str, 0) + 1);
                if (sMap.get(str) > wordsMap.get(str)) {
                    break;
                }
            }
            if (j == m) {
                res.add(i);
            }
        }
        return res;
    }
}