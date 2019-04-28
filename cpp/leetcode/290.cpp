class Solution {
public:
    bool wordPattern(string pattern, string str) {
        vector<string> strs;
        istringstream in(str);
        string word = "";
        while(in >> word) strs.push_back(word);
        unordered_map<char, int> pmap;
        unordered_map<string, int> smap;
        if(pattern.size() != strs.size()) return false;
        for(int i = 0; i < strs.size(); i++){
            int idx1 = pmap.find(pattern[i]) == pmap.end() ? -1 : pmap[pattern[i]];
            int idx2 = smap.find(strs[i]) == smap.end() ? -1 : smap[strs[i]];
            if(idx1 != idx2) return false;
            pmap[pattern[i]] = i;
            smap[strs[i]] = i;
        }
        return true;
    }
};