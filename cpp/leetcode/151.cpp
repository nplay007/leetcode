class Solution {
  public:
    void reverseWords(string &s) {
        reverse(s.begin(), s.end());
        int idx = 0;
        for (int i = 0, j = 0; i < s.size(); i++) {
            if (s[i] != ' ') {
                if (idx != 0) {
                    s[idx++] = ' ';
                }
                for (j = i; j < s.size() && s[j] != ' '; j++) {
                    s[idx++] = s[j];
                }
                reverse(s.begin() + idx - (j - i), s.begin() + idx);
                i = j;
            }
        }
        s.erase(s.begin() + idx, s.end());
    }
};