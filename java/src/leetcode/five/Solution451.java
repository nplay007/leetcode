package JavaAnswer.five;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution451 {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<List<Character>> bucket = new ArrayList<>(s.length() + 1);
        for (int i = 0; i < s.length() + 1; i++) {
            bucket.add(new ArrayList<>());
        }
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            bucket.get(frequency).add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.size() - 1; i >= 0; i--) {
            if (bucket.get(i) != null) {
                for (char num : bucket.get(i)) {
                    for (int j = 0; j < map.get(num); j++) {
                        sb.append(num);
                    }
                }
            }
        }
        return sb.toString();
    }
}

class Solution451II {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(map.size(), (a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> node = pq.poll();
            for (int i = 0; i < node.getValue(); i++) {
                sb.append(node.getKey());
            }
        }
        return sb.toString();
    }
}
