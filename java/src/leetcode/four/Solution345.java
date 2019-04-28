package JavaAnswer.four;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution345 {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !vowels.contains(Character.toLowerCase(chars[left]))) {
                left++;
            }
            while (left < right && !vowels.contains(Character.toLowerCase(chars[right]))) {
                right--;
            }
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
        return new String(chars);
    }
}