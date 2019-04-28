class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if (s.size() != t.size()) {
            return false;
        }
        int word1[256] = {0}, word2[256] = {0}, n = s.size();
        for (int i = 0; i < n; ++i) {
            if (word1[s[i]] != word2[t[i]]) {
                return false;
            }
            word1[s[i]] = i + 1; // avoid 0 idx
            word2[t[i]] = i + 1;
        }
        return true;
    }
};

class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if (s.size() != t.size()) {
            return false;
        }
        unordered_map<char, int> smap;
        unordered_map<char, int> tmap;
        for (int i = 0; i < s.size(); i++) {
            int sidx = smap.find(s[i]) != smap.end() ? smap[s[i]] : -1;
            int tidx = tmap.find(t[i]) != tmap.end() ? tmap[t[i]] : -1;
            if (sidx != tidx) {
                return false;
            }
            smap[s[i]] = i;
            tmap[t[i]] = i;
        }
        return true;
    }
};