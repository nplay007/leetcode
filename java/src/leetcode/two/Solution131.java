package JavaAnswer.two;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<List<String>> result = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        dfs(s, 0, ans, result);
        return result;
    }

    public void dfs(String s, int start, List<String> ans, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(ans));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                ans.add(s.substring(start, i + 1));
                dfs(s, i + 1, ans, res);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}

class Solution131DP {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        int n = s.length();
        List<List<List<String>>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(new ArrayList<>());

        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < s.length(); i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    String str = s.substring(j, i + 1);
                    for (List<String> ans : result.get(j)) {
                        List<String> newPart = new ArrayList<String>(ans);
                        newPart.add(str);
                        result.get(i + 1).add(newPart);
                    }
                }
            }
        }
        return result.get(n);
    }
}