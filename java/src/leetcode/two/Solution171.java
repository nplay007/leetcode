package JavaAnswer.two;

public class Solution171 {
    public int titleToNumber(String s) {
        int result = 0;
        for (char ch : s.toCharArray()) {
            result = 26 * result + ch - 'A' + 1;
        }
        return result;
    }
}