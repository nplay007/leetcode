package JavaAnswer.four;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            result.add("");
            return result;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        boolean found = false;
        queue.add(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (isValidParentheses(str)) {
                    found = true;
                    result.add(str);
                }
                if (found) {
                    continue;
                }
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == '(' || str.charAt(j) == ')') {
                        String next = str.substring(0, j) + str.substring(j + 1);
                        if (visited.add(next)) {
                            queue.add(next);
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isValidParentheses(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                count++;
            }
            if (ch == ')' && count-- == 0) {
                return false;
            }
        }
        return count == 0;
    }
}