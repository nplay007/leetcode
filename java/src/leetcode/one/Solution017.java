package JavaAnswer.one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution017 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] board = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> result = new LinkedList<>();
        result.add("");
        for (char digit : digits.toCharArray()) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                String ans = result.remove(0);
                for (char ch : board[digit - '0'].toCharArray()) {
                    result.add(ans + ch);
                }
            }
        }
        return result;
    }
}

class Solution017Recursion {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] board = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> result = new ArrayList<>();
        letterCombinations(0, "", digits, board, result);
        return result;
    }

    private void letterCombinations(int start, String ans, String digits, String[] board, List<String> result) {
        if (ans.length() == digits.length()) {
            result.add(ans);
            return;
        }
        for (char ch : board[digits.charAt(start) - '0'].toCharArray()) {
            letterCombinations(start + 1, ans + ch, digits, board, result);
        }
    }
}