package JavaAnswer.five;

public class Solution484 {
    public int[] findPermutation(String s) {
        int[] result = new int[s.length() + 1];
        result[0] = 1;
        int i = 1;
        while (i <= s.length()) {
            result[i] = i + 1;
            int j = i;
            if (s.charAt(i - 1) == 'D') {
                while (i <= s.length() && s.charAt(i - 1) == 'D') {
                    i++;
                }
                for (int k = j - 1, c = i; k <= i - 1; k++, c--) {
                    result[k] = c;
                }
            }
            else {
                i++;
            }
        }
        return result;
    }
}
