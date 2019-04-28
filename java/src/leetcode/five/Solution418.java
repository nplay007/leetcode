package JavaAnswer.five;

public class Solution418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int idx = 0, n = s.length();
        for (int i = 0; i < rows; i++) {
            idx += cols;
            if (s.charAt(idx % n) == ' ') {
                idx++;
            }
            else {
                while (idx > 0 && s.charAt((idx - 1) % n) != ' ') {
                    idx--;
                }
            }
        }
        return idx / n;
    }
}