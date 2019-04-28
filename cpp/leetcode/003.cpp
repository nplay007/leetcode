class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> words;
        int last = 0, longestSubstr = 0;
        for (int i = 0; i < s.size(); i++) {
            if (words.find(s[i]) != words.end()) {
                last = max(last, words[s[i]] + 1);
            }
            words[s[i]] = i;
            longestSubstr = max(longestSubstr, i - last + 1);
        }
        return longestSubstr;
    }
};