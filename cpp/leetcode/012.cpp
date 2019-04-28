class Solution {
  public:
    string intToRoman(int num) {
        if (num < 0) {
            throw invalid_argument("negative number");
        }
        string romans[13] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int nums[13] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        string res = "";
        for (int i = 12; i >= 0; --i) {
            while (num >= nums[i]) {
                res += romans[i];
                num -= nums[i];
            }
        }
        return res;
    }
};