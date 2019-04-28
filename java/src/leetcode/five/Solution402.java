package JavaAnswer.five;

public class Solution402 {
    public String removeKdigits(String num, int k) {
        int leftDigits = num.length() - k;  // left digits
        char[] digits = new char[num.length()];
        int top = 0;
        for (char ch : num.toCharArray()) {
            while (top > 0 && digits[top - 1] > ch && k > 0) {
                top -= 1;
                k -= 1;
            }
            digits[top++] = ch;
        }
        int idx = 0;
        while (idx < leftDigits && digits[idx] == '0') {
            idx++;
        }
        return idx == leftDigits ? "0" : new String(digits, idx, leftDigits - idx);
    }
}