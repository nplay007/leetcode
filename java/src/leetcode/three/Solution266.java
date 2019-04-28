package JavaAnswer.three;

import java.util.HashSet;
import java.util.Set;

public class Solution266 {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
            }
            else {
                set.add(ch);
            }
        }
        return set.size() < 2;
    }
}