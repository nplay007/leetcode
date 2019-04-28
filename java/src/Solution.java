public class Solution {
    public int getNext(String s) {
        int[] next = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int j = next[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            j += s.charAt(i) == s.charAt(j) ? 1 : 0;
            next[i] = j;
        }
        int sum = 0;
        for (int num : next) {
            sum += num;
        }
        return sum;
    }
}
