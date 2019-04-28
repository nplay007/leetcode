package JavaAnswer.six;

public class Solution541 {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k < 0) {
            return "";
        }
        char[] words = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int end = Math.min(i + k - 1, s.length() - 1);
            swap(words, i, end);
        }
        return new String(words);
    }

    private void swap(char[] words, int left, int right) {
        while (left < right) {
            char tmp = words[left];
            words[left++] = words[right];
            words[right--] = tmp;
        }
    }
}