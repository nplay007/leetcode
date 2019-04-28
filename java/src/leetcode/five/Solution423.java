package JavaAnswer.five;

public class Solution423 {
    static String[] digits = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    static char[] ids = { 'z', 'o', 'w', 'h', 'u', 'f', 'x', 's', 'g', 'i' };
    static int[] order = { 0, 2, 4, 6, 8, 1, 3, 5, 7, 9 };

    public String originalDigits(String s) {
        int[] dCount = new int[10], lCount = new int[26];
        for (char ch : s.toCharArray()) {
            lCount[ch - 'a']++;
        }
        for (int d : order) {
            dCount[d] = lCount[ids[d] - 'a'];
            for (char c : digits[d].toCharArray())  {
                lCount[c - 'a'] -= dCount[d];
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < dCount[i]; ++j) {
                ans.append(i);
            }
        }
        return ans.toString();
    }
}
