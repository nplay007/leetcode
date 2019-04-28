package JavaAnswer.three;

public class Solution245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE;
        int idx1 = -1;
        int idx2 = -1;
        boolean same = word1.equals(word2);
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                idx1 = i;
            }
            if (words[i].equals(word2)) {
                if (same) {
                    idx1 = idx2;
                }
                idx2 = i;
            }
            if (idx1 != -1 && idx2 != -1) {
                result = Math.min(result, Math.abs(idx1 - idx2));
            }
        }
        return result;
    }
}