class Solution {
public:
    bool detectCapitalUse(string word) {
        int cnts = 0, n = word.size();
        for (int i = 0; i < n; ++i) {
            if (word[i] <= 'Z') {
                ++cnts;
            }
        }
        return cnts == 0 || cnts == n || (cnts == 1 && word[0] <= 'Z');
    }
};