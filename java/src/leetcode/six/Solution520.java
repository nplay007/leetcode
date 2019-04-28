package JavaAnswer.six;

public class Solution520 {
    public boolean detectCapitalUse(String word) {
        int cnts = 0, n = word.length();
        for (char ch : word.toCharArray()) {
            if (ch <= 'Z') {
                cnts++;
            }
        }
        return cnts == 0 || cnts == n || (cnts == 1 && word.charAt(0) <= 'Z');
    }
}