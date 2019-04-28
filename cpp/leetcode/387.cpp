class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map <char, int> words;
        for(char ch : s) words[ch] ++;
        for(int i = 0; i < s.size(); i++){
            if(words[s[i]] == 1) return i;
        }
        return -1;
    }
};