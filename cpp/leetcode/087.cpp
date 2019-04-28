class Solution {
public:
    bool isScramble(string s1, string s2) {
        if(s1 == s2) return true;
        unordered_map<char, int> map;
        for(auto ch : s1) map[ch]++;
        for(auto ch : s2) map[ch]--;
        for(auto it : map){
            if(it.second != 0) return false;
        }
        int n = s1.size();
        for(int i = 1; i < n; i++){
            if(isScramble(s1.substr(0, i), s2.substr(0, i))  && isScramble(s1.substr(i), s2.substr(i))) return true;
            if(isScramble(s1.substr(0, i), s2.substr(n - i)) && isScramble(s1.substr(i), s2.substr(0, n - i))) return true;
        }
        return false;
    }
};