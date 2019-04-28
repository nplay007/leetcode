package JavaAnswer.three;

public class Solution214 {
    public String shortestPalindrome(String s) {
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().substring(0, s.length() - getNext(s)) + s;
    }

    private int getNext(String str) {
        StringBuilder builder = new StringBuilder(str);
        String rev = new StringBuilder(str).reverse().toString();
        builder.append("#").append(rev);
        int[] next = new int[builder.length()];
        for (int i = 1; i < next.length; i++) {
            int j = next[i - 1];
            while (j > 0 && builder.charAt(i) != builder.charAt(j)) {
                j = next[j - 1];
            }
            if (builder.charAt(i) == builder.charAt(j)) {
                next[i] = j + 1;
            }
        }
        return next[next.length - 1];
    }
}