package JavaAnswer.one;

import java.util.HashMap;
import java.util.Map;

public class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>(); // char : index
        int longestSubstr = 0, start = 0; // start of substring
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i)) + 1); // start of substring
            }
            map.put(s.charAt(i), i);
            longestSubstr = Math.max(longestSubstr, i - start + 1);
        }
        return longestSubstr;
    }
}