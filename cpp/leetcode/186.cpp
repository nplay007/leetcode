class Solution {
  public:
    void reverseWords(string &s) {
        reverse(s.begin(), s.end());
        for (int i = 0, j = 0; i < s.size(); i = j + 1) {
            for (j = i; j < s.size() && s[j] != ' '; j++) ;
            reverse(s.begin() + i, s.begin() + j);
        }
    }
};