package JavaAnswer.five;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution500 {
    public String[] findWords(String[] words) {
        String[] charsInRow = { "QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM" };
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charsInRow.length; i++) {
            for (char ch : charsInRow[i].toCharArray()) {
                map.put(ch, i);// put <char, rowIndex> pair into the map
            }
        }
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word == null || word.equals("")) {
                continue;
            }
            int index = map.get(word.toUpperCase().charAt(0));
            for (char ch : word.toUpperCase().toCharArray()) {
                if (map.get(ch) != index) {
                    index = -1;
                    break;
                }
            }
            if (index != -1) {
                result.add(word);  // a valid string
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
