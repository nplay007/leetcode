package JavaAnswer.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution022 {
    public List<String> generateParenthesis(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid number");
        }
        List<String> result = new LinkedList<>();
        generateParenthesis(n, n, "", result);
        return result;
    }

    void generateParenthesis(int left, int right, String ans, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(ans);
            return;
        }
        if (left <= right && left > 0) {
            generateParenthesis(left - 1, right, ans + '(', result);
        }
        if (left <= right && right > 0) {
            generateParenthesis(left, right - 1, ans + ')', result);
        }
    }
}

class Solution022Iterative {
    public List<String> generateParenthesis(int n) {
        List<List<String>> result = new ArrayList<>();
        result.add(Collections.singletonList(""));

        for (int i = 1; i <= n; ++i) {
            final List<String> ans = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                for (String first : result.get(j)) {
                    for (String second : result.get(i - 1 - j)) {
                        ans.add("(" + first + ")" + second);
                    }
                }
            }
            result.add(ans);
        }
        return result.get(result.size() - 1);
    }
}