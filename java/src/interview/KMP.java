package interview;

public class KMP {
    public int[] getNext(String s) {
        int[] next = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int j = next[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            j += s.charAt(i) == s.charAt(j) ? 1 : 0;
            next[i] = j;
        }
        return next;
    }

    public int getKMP(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        int m = haystack.length(), n = needle.length();
        int[] next = new int[n];
        for (int i = 1; i < n; i++) {
            int j = next[i - 1];
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                next[i] = j + 1;
            }
        }
        int i = 0, j = 0;
        while (i < m) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }

            if (j == n) {
                return i - n + 1;
            }
        }
        return -1;
    }
}
