package JavaAnswer.five;

public class Solution482 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-') {
                result.append(result.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
            }
        return result.reverse().toString().toUpperCase();
    }
}
