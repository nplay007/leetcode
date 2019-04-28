package JavaAnswer.three;

import java.util.HashMap;
import java.util.Map;

public class Solution291 {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        return isMatch(str, 0, pattern, 0, map);
    }

    boolean isMatch(String str, int i, String pattern, int j, Map<Character, String> map) {
        if (i == str.length() && j == pattern.length()) {
            return true;
        }
        if (i == str.length() || j == pattern.length()) {
            return false;
        }
        char ch = pattern.charAt(j);
        if (map.containsKey(ch)) {
            String s = map.get(ch);
            if (!str.startsWith(s, i)) {
                return false;
            }
            return isMatch(str, i + s.length(), pattern, j + 1, map);
        }
        for (int k = i; k < str.length(); k++) {
            String p = str.substring(i, k + 1);
            if (map.containsValue(p)) {
                continue;
            }
            map.put(ch, p);
            if (isMatch(str, k + 1, pattern, j + 1, map)) {
                return true;
            }
            map.remove(ch);
        }
        return false;
    }
}
