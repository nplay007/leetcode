class Solution {
  public:
    int lengthOfLastWord(string s) {
        int res = 0, idx = s.size() - 1;
        for (; idx >= 0 && s[idx] == ' '; --idx);
        for (; idx >= 0 && s[idx] != ' '; ++res, --idx);
        return res;
    }
};