package JavaAnswer.three;

import java.util.ArrayList;
import java.util.List;

public class Solution282 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        dfs(res, "", num, target, 0, 0, 0);
        return res;
    }

    public void dfs(List<String> res, String ans, String num, int target, int start, long eval, long pre) {
        if (start == num.length()) {
            if (target == eval) {
                res.add(ans);
            }
            return;
        }
        for (int i = start; i < num.length(); i++) {
            if (i != start && num.charAt(start) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(start, i + 1));
            if (start == 0) {
                dfs(res, ans + cur, num, target, i + 1, cur, cur);
            }
            else {
                dfs(res, ans + "+" + cur, num, target, i + 1, eval + cur, cur);
                dfs(res, ans + "-" + cur, num, target, i + 1, eval - cur, -cur);
                dfs(res, ans + "*" + cur, num, target, i + 1, eval + pre * (cur - 1), pre * cur);
            }
        }
    }
}