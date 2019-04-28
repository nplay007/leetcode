package JavaAnswer.one;

import java.util.ArrayList;
import java.util.List;

public class Solution068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        for (int i = 0, count = 0, total = 0; i < words.length; i += count) {
            count = 0;
            total = 0;
            while (i + count < words.length && total + words[i + count].length() <= maxWidth - count) {
                total += words[i + count].length();
                count++;
            }

            StringBuilder sb = new StringBuilder(words[i]);
            for (int j = 0; j < count - 1; j++) {
                if (i + count >= words.length) {
                    sb.append(" "); // last line need space
                }
                // 10 space, 5 word, so 10 / 4 = 2, 10 % 4 = 2, the 2 more space put int 1 and 2 space
                else {
                    int len = (maxWidth - total) / (count - 1);
                    if (j < (maxWidth - total) % (count - 1)) {
                        len++;
                    }
                    for (int k = 0; k < len; k++) {
                        sb.append(' ');
                    }
                }
                sb.append(words[i + j + 1]);
            }

            // space after last word
            int len = maxWidth - sb.length();
            for (int k = 0; k < len; k++) {
                sb.append(' ');
            }
            result.add(sb.toString());
        }
        return result;
    }
}
