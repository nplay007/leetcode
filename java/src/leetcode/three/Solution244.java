package JavaAnswer.three;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class WordDistance {
    private Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new LinkedList<>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int result = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < list1.size() && j < list2.size();) {
            int idx1 = list1.get(i);
            int idx2 = list2.get(j);
            if (idx1 < idx2) {
                result = Math.min(result, idx2 - idx1);
                i++;
            }
            else {
                result = Math.min(result, idx1 - idx2);
                j++;
            }
        }
        return result;
    }
}
