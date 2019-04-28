package JavaAnswer.two;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        queue.add(beginWord);
        int level = 1; // beginWord ==> 1
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (str.equals(endWord)) {
                    return level;
                }
                for (int j = 0; j < str.length(); j++) {
                    StringBuilder sb = new StringBuilder(str);
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == sb.charAt(j)) {
                            continue;
                        }
                        sb.setCharAt(j, ch);
                        String word = sb.toString();
                        if (wordSet.contains(word)) {
                            queue.add(word);
                            wordSet.remove(word);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}