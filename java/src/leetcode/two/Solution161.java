package JavaAnswer.two;

public class Solution161 {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return s == null ? t.length() == 1 : s.length() == 1;
        }
        if (t.length() > s.length()) {
            return isOneEditDistance(t, s);
        }
        // t.length() <= s.length()
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                else {
                    return t.substring(i).equals(s.substring(i + 1));
                }
            }
        }
        return s.length() - t.length() == 1;
    }
}