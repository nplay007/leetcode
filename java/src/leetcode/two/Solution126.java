package JavaAnswer.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution126 {
    List<List<String>> results; // result to return
    List<String> ans;
    Map<String, List<String>> map; // graph

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) {
            return results;
        }
        results = new ArrayList<>();
        ans = new LinkedList<>();
        map = new HashMap<>();

        boolean found = false;

        Queue<String> queue = new LinkedList<>(); // BFS queue
        Set<String> unvisited = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();

        queue.add(beginWord);
        unvisited.add(endWord);
        unvisited.remove(beginWord);
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                String word = queue.poll();
                for (int i = 0; i < word.length(); i++) {
                    StringBuilder sb = new StringBuilder(word);
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        sb.setCharAt(i, ch);
                        String nextWord = sb.toString();
                        if (unvisited.contains(nextWord)) {
                            if (visited.add(nextWord)) {// Avoid Duplicate queue insertion
                                queue.add(nextWord);
                            }

                            if (!map.containsKey(nextWord)) {// Build Adjacent Graph
                                map.put(nextWord, new LinkedList<>());
                            }
                            map.get(nextWord).add(word);

                            if (nextWord.equals(endWord) && !found) {
                                found = true;
                            }
                        }
                    }
                }
            }
            if (found) {
                break;
            }
            unvisited.removeAll(visited);
            visited.clear();
        }
        dfs(endWord, beginWord);
        return results;
    }

    private void dfs(String word, String start) {
        if (word.equals(start)) {
            ans.add(0, start);
            results.add(new ArrayList<>(ans));
            ans.remove(0);
            return;
        }
        ans.add(0, word);
        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                dfs(s, start);
            }
        }
        ans.remove(0);
    }
}