package JavaAnswer.one;

public class Solution067 {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sum += carry;
            carry = sum / 2;
            result.append(sum % 2);
        }
        return result.reverse().toString();
    }
}