class Solution {
public:
    int lengthOfLongestSubstringTwoDistinct(string s) {
        unordered_map<char, int> words;
        int res = 0, left = 0;
        for(int i = 0; i < s.size(); i++){
            words[s[i]]++;
            while(words.size() > 2){
                if(--words[s[left]] == 0) words.erase(s[left]);
                left++;
            }
            res = max(res, i - left + 1);
        }
        return res;
    }
};