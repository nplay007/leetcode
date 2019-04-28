package JavaAnswer.one;

public class Solution066 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // only when digits are 9999=>10000
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}