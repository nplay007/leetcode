package JavaAnswer.three;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution269 {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        if (words == null || words.length == 0) {
            return sb.toString();
        }
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                degree.put(ch, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int len = Math.min(cur.length(), next.length());
            for (int j = 0; j < len; j++) {
                char ch1 = cur.charAt(j);
                char ch2 = next.charAt(j);
                if (ch1 != ch2) {
                    Set<Character> set = map.getOrDefault(ch1, new HashSet<>());
                    if (!set.contains(ch2)) {
                        set.add(ch2);
                        map.put(ch1, set);
                        degree.put(ch2, degree.get(ch2) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char ch : degree.keySet()) {
            if (degree.get(ch) == 0) {
                queue.add(ch);
            }
        }
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            sb.append(ch);
            if (map.containsKey(ch)) {
                for (char c2 : map.get(ch)) {
                    degree.put(c2, degree.get(c2) - 1);
                    if (degree.get(c2) == 0) {
                        queue.add(c2);
                    }
                }
            }
        }
        if (sb.length() != degree.size()) {
            return "";
        }
        return sb.toString();
    }
}