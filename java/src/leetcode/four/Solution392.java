package JavaAnswer.four;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}

class Solution392FollowUp {
    public boolean isSubsequence(String s, String t) {
        List<List<Integer>> idx = new ArrayList<>(256); // Just for clarity
        for (int i = 0; i < t.length(); i++) {
            idx.get(t.charAt(i)).add(i);
        }

        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (idx.get(s.charAt(i)) == null) {
                return false;
            }
            int j = Collections.binarySearch(idx.get(s.charAt(i)), prev);
            if (j < 0) {
                j = -j - 1;
            }
            if (j == idx.get(s.charAt(i)).size()) {
                return false;
            }
            prev = idx.get(s.charAt(i)).get(j) + 1;
        }
        return true;
    }
}