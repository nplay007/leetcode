class Solution {
  public:
    string convert(string s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        vector<string> res(numRows, "");
        for (int i = 0; i < s.size(); i++) {
            int idx = i % (2 * numRows - 2);
            int j = idx < numRows ? idx : 2 * numRows - 2 - idx;
            strs[j] += s[i];
        }
        string result = "";
        for (auto str : res) {
            result += str;
        }
        return result;
    }
};