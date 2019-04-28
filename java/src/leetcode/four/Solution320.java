package JavaAnswer.four;

import java.util.ArrayList;
import java.util.List;

public class Solution320 {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        dfs(0, 0, "", word, res);
        return res;
    }

    private void dfs(int start, int len, String ans, String word, List<String> res) {
        if (start == word.length()) {
            if (len > 0) {
                ans += len;
            }
            res.add(ans);
            return;
        }
        dfs(start + 1, len + 1, ans, word, res); // omit
        dfs(start + 1, 0, ans + (len > 0 ? len : "") + word.charAt(start), word, res); //keep
    }
}