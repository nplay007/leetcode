class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        unordered_map<char, int> counts;
        for (int i = 0; i < n; i++) {
            counts[s[i]]++;
            counts[t[i]]--;
        }
        for (auto it : counts)
            if (it.second) return false;
        return true;
    }
};



bool isAnagram(string s, string t) {
    if (s.size() != t.size()) return false;
    int n = s.size();
    int counts[256] = {0};
    for (int i = 0; i < n; i++) { 
        counts[s[i] - 'a']++;
        counts[t[i] - 'a']--;
    }
    for (int i = 0; i < 26; i++)
        if (counts[i]) return false;
    return true;
}


bool isAnagram(string s, string t) { 
    sort(s.begin(), s.end());
    sort(t.begin(), t.end());
    return s == t; 
}
