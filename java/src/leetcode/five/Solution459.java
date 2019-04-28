package JavaAnswer.five;

public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        int[] next = new int[l];
        next[0] = -1;
        int i, j = -1;
        for (i = 1; i < l; i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        int lenSub = l - 1 - next[l - 1];
        return lenSub != l && l % lenSub == 0;
    }
}

class Solution459II {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i != 0) {
                continue;
            }
            String baseString = s.substring(0, i);
            int j = 0;
            while (j * i < s.length()) {
                String next = s.substring(i * j, i * (j + 1));
                if (!next.equals(baseString)) {
                    break;
                }
                j++;
            }
            if (j == (s.length() / i)) {
                return true;
            }
        }
        return false;
    }
}