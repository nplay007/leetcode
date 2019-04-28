package JavaAnswer.two;

import java.util.Arrays;
import java.util.Collections;

class Solution151Built {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}

public class Solution151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] str = s.toCharArray();
        reverse(str, 0, str.length - 1);
        int idx = 0;
        for (int i = 0, j = 0; i < str.length; i++) {
            if (str[i] != ' ') {
                if (idx != 0) {
                    str[idx++] = ' ';
                }
                for (j = i; j < str.length && str[j] != ' '; j++) {
                    str[idx++] = str[j];
                }
                reverse(str, idx - (j - i), idx - 1);
                i = j;
            }
        }
        return new String(str, 0, idx);

    }

    private void reverse(char[] str, int left, int right) {
        while (left < right) {
            char tmp = str[left];
            str[left++] = str[right];
            str[right--] = tmp;
        }
    }
}