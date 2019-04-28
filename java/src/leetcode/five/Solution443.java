package JavaAnswer.five;

public class Solution443 {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int start = 0; // start location of next char
        int idx = 0; // write index for new chars array
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 == chars.length || chars[i + 1] != chars[i]) {
                chars[idx++] = chars[start];
                if (i > start) {
                    for (char ch : String.valueOf(i - start + 1).toCharArray()) {
                        chars[idx++] = ch;
                    }
                }
                start = i + 1;
            }
        }
        return idx;
    }
}
