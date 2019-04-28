package interview;

/*
 * Most Frequenct Character in a String
 * hashmap存频率，然后维持count最大的
 * */

import java.util.HashMap;
import java.util.Map;

public class mostFrequentCharacterInString {
    public char findMostFrequent(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        char res = ' ';
        for (char ch : s.toCharArray()) {
            ch = Character.toLowerCase(ch); // 不区分大小写
            if (!Character.isLetterOrDigit(ch) || ch == ' ') {
                continue;
            }
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) > count) {
                count = map.get(ch);
                res = ch;
            }
        }
        return res;
    }


    // Follow Up:
    // 优化时间，count维持两个，频率第一大，第二大，1-2如果>=剩下的，就可以了。
    public char findMostFrequent2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count1 = 0, count2 = 0;
        char c1 = ' ';//, c2 = '';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!Character.isLetterOrDigit(ch)) {
                continue;
            }
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) >= count1) {
                count2 = count1;
                count1 = map.get(ch);
                c1 = ch;
            } else if (map.get(ch) >= count2) {
                count2 = map.get(ch);
            }
            if (count1 - count2 >= s.length() - i) {
                return c1;
            }
        }
        return c1;
    }
}
