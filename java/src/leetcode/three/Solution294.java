package JavaAnswer.three;

import java.util.HashMap;
import java.util.Map;

public class Solution294 {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        return dfs(s);
    }

    public boolean dfs(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!dfs(t)) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Solution294DP {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Map<String, Boolean> map = new HashMap<>();
        return dfs(s, map);
    }

    private boolean dfs(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String newStr = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!dfs(newStr, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}