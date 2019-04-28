package JavaAnswer.one;

import java.util.HashMap;
import java.util.Map;

public class Solution076 {
    String minWindow(String s, String t) {
        int miss = t.length();
        int[] need = new int[256];
        for (char ch : t.toCharArray()) {
            need[ch]++;
        }
        int width = Integer.MAX_VALUE, idx = 0;
        int left = 0, right = 0;
        // chars not in t will get negative count
        while (right < s.length()) {
            if (need[s.charAt(right++)]-- > 0) {
                miss--;
            }
            while (miss == 0) {
                if (right - left < width) { // right has increased
                    width = right - left;
                    idx = left;
                }
                if (need[s.charAt(left++)]++ == 0) {
                    miss++;
                }
            }
        }
        return width == Integer.MAX_VALUE ? "" : s.substring(idx, idx + width);
    }
}

class Solution076II {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, 0);
        }
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int minStart = 0, minLen = Integer.MAX_VALUE, miss = t.length();
        for (int left = 0, right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.get(ch) > 0) {
                miss--;
            }
            map.put(ch, map.get(ch) - 1);
            while (miss == 0) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                if (map.get(s.charAt(left)) > 0) {
                    miss++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}