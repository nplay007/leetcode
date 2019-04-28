package JavaAnswer.seven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("negative num!");
        }
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        int[] counts = new int[26];
        for (int task : tasks) {
            counts[task - 'A']++;
        }
        Arrays.sort(counts);
        int i = 25;
        while (i >= 0 && counts[i] == counts[25]) {
            i--;
        }
        return Math.max(tasks.length, (counts[25] - 1) * (n + 1) + 25 - i);
    }
}

class Solution621II {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        int result = 0;
        while (!pq.isEmpty()) {
            int k = n + 1;
            List<Map.Entry<Character, Integer>> left = new ArrayList<>();
            while (k > 0 && !pq.isEmpty()) {
                Map.Entry<Character, Integer> top = pq.poll();
                if (top.getValue() > 1) {
                    top.setValue(top.getValue() - 1);
                    left.add(top);
                }
                k--;
                result++; // successfully executed task
            }
            pq.addAll(left);
            if (pq.isEmpty()) {
                break;
            }
            result = result + k; // if k > 0, then it means we need to be idle
        }
        return result;
    }
}