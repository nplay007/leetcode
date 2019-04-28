package JavaAnswer.four;

public class Solution387 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] freq = new int[256];
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}