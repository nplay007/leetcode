package JavaAnswer.seven;

public class Solution616 {
    public String addBoldTag(String s, String[] dict) {
        StringBuilder res = new StringBuilder("");
        int n = s.length(), end = 0;
        boolean[] bold = new boolean[n];
        for (int i = 0; i < n; ++i) {
            for (String word : dict) {
                int len = word.length();
                if (i + len <= n && s.substring(i, i + len) == word) {
                    end = Math.max(end, i + len);
                }
            }
            bold[i] = end > i;
        }
        for (int i = 0; i < n; ++i) {
            if (!bold[i]) {
                res.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < n && bold[j])
                ++j;
            res.append("<b>").append(s.substring(i, j)).append("</b>");
            i = j - 1;
        }
        return res.toString();
    }
}