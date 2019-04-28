class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char, int> words;
        for(auto ch : s) {
            words[ch]++;
        }
        bool flag = false;
        int res = 0;
        for(auto it : words){
            if(it.second % 2 == 0) {
                res += it.second;
            } else {
                res += flag ? it.second - 1 : it.second;
                flag = true;
            }
        }
        return res;
    }
};