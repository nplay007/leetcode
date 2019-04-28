package JavaAnswer.three;

import java.util.HashMap;
import java.util.Map;

public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chOfS = s.charAt(i);
            char chOfT = t.charAt(i);
            if (map.containsKey(chOfS)) {
                if (map.get(chOfS) != chOfT) {
                    return false;
                }
            }
            else {
                if (map.containsValue(chOfT)) {
                    return false;
                }
                map.put(chOfS, chOfT);
            }
        }
        return true;
    }
}

class Solution205II {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> mapOfS = new HashMap<>();
        Map<Character, Integer> mapOfT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int idxOfs = mapOfS.getOrDefault(s.charAt(i), -1);
            int idxOft = mapOfT.getOrDefault(t.charAt(i), -1);
            if (idxOfs != idxOft) {
                return false;
            }
            mapOfS.put(s.charAt(i), i);
            mapOfT.put(t.charAt(i), i);
        }
        return true;
    }
}