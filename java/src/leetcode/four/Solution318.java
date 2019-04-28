package JavaAnswer.four;

public class Solution318 {
    public static int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                mask[i] |= 1 << (ch - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++) {
                if ((mask[i] & mask[j]) == 0 && (words[i].length() * words[j].length() > res)) {
                    res = words[i].length() * words[j].length();
                }
            }
        return res;
    }
}