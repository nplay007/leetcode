package JavaAnswer.one;

public class Solution012 {
    public String intToRoman(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("num can't be negative.");
        }
        String[] romans = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
        int[] nums = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        StringBuilder res = new StringBuilder("");
        for (int i = nums.length - 1; i >= 0; --i) {
            while (num >= nums[i]) {
                res.append(romans[i]);
                num -= nums[i];
            }
        }
        return res.toString();
    }
}