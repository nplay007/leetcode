package JavaAnswer.four;

import java.util.HashMap;
import java.util.Map;

public class Solution340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, left = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) {
                num++;
            }
            if (num > k) {
                while (--count[s.charAt(left++)] > 0) ;
                num--;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}

class Solution340II {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int longestSubstring = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() > k) {
                char charAtLeft = s.charAt(left);
                map.put(charAtLeft, map.get(charAtLeft) - 1); // charAtLeft should in map
                if (map.get(charAtLeft) == 0) {
                    map.remove(charAtLeft);
                }
                left++;
            }
            longestSubstring = Math.max(longestSubstring, i - left + 1);
        }
        return longestSubstring;
    }
}