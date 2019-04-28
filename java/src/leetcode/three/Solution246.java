package JavaAnswer.three;

import java.util.HashMap;
import java.util.Map;

public class Solution246 {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            char chOfLeft = num.charAt(left++);
            char chOfRight = num.charAt(right--);
            if (map.getOrDefault(chOfLeft, '#') != chOfRight) {
                return false;
            }
        }
        return true;
    }
}