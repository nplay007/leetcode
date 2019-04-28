package JavaAnswer.five;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution433 {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        Set<String> bankSet = new HashSet<>();
        for (String b : bank) {
            bankSet.add(b);
        }
        char[] charSet = new char[] { 'A', 'C', 'G', 'T' };
        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(end)) {
                    return level;
                }
                char[] words = cur.toCharArray();
                for (int i = 0; i < words.length; i++) {
                    char tmp = words[i];
                    for (char ch : charSet) {
                        words[i] = ch;
                        String next = new String(words);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    words[i] = tmp;
                }
            }
            level++;
        }
        return -1;
    }
}
