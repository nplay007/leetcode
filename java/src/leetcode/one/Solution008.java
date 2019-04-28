package JavaAnswer.one;

public class Solution008 {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if (i == str.length()) {
            return 0;
        }
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i++) == '+' ? 1 : -1;
        }
        long result = 0; // overflow
        while (i < str.length()) {
            char ch = str.charAt(i++);
            if (ch < '0' || ch > '9') {
                break;
            }
            result = 10 * result + ch - '0';
            if (sign * result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign * result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) (result * sign);
    }
}