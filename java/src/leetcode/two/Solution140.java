package JavaAnswer.two;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, wordSet, new HashMap<String, LinkedList<String>>());
    }

    private List<String> dfs(String s, Set<String> wordSet, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        LinkedList<String> result = new LinkedList<>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }
        for (String word : wordSet) {
            if (s.startsWith(word)) {
                List<String> subList = dfs(s.substring(word.length()), wordSet, map);
                for (String subStr : subList) {
                    result.add(word + (subStr.isEmpty() ? "" : " ") + subStr);
                }
            }
            map.put(s, result);
        }
        return result;
    }
}

class Solution140II {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, wordSet, new HashMap<String, LinkedList<String>>());
    }

    private LinkedList<String> dfs(String s, Set<String> wordSet, HashMap<String, LinkedList<String>> map) {
        LinkedList<String> result = new LinkedList<>();
        if (wordSet.contains(s)) {
            result.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            LinkedList<String> ans = new LinkedList<>();
            String prefix = s.substring(0, i), suffix = s.substring(i);
            if (!wordSet.contains(prefix)) {
                continue;
            }
            if (map.containsKey(suffix)) {
                ans = map.get(suffix);
            }
            else {
                ans = dfs(suffix, wordSet, map);
            }
            for (String str : ans) {
                result.add(prefix + " " + str);
            }
        }
        map.put(s, result);
        return result;
    }
}