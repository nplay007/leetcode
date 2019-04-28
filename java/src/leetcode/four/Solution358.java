package JavaAnswer.four;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution358 {
    public String rearrangeString(String str, int k) {
        int length = str.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        for (int i = 0; i < length; i++) {
            count[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int idx = findValidMax(count, valid, i);
            if (idx == -1) {
                return "";
            }
            count[idx]--;
            valid[idx] = i + k;
            sb.append((char) ('a' + idx));
        }
        return sb.toString();
    }

    private int findValidMax(int[] count, int[] valid, int index) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] > max && index >= valid[i]) {
                max = count[i];
                idx = i;
            }
        }
        return idx;
    }
}

class Solution358PQ {
    public String rearrangeString(String str, int k) {
        StringBuilder sb = new StringBuilder();
        // count frequency of each char
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        maxHeap.addAll(map.entrySet());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();
            sb.append(current.getKey());
            current.setValue(current.getValue() - 1);
            waitQueue.offer(current);
            if (waitQueue.size() < k) {
                continue;
            }
            Map.Entry<Character, Integer> front = waitQueue.poll();
            if (front.getValue() > 0) {
                maxHeap.offer(front);
            }
        }
        return sb.length() == str.length() ? sb.toString() : "";
    }
}