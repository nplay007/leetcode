package JavaAnswer.one;

public class Solution043 {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int multiple = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                multiple += result[i + j + 1];
                result[i + j + 1] = multiple % 10;
                result[i + j] += multiple / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            if (digit != 0 || sb.length() != 0) {
                sb.append(digit);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}