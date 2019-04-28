class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> pv(256,0), sv(256,0), res;
        if(s.size() < p.size()) return res;
        for(int i = 0; i < p.size(); ++i) {
            ++pv[p[i]];
            ++sv[s[i]];
        }
        if(pv == sv) res.push_back(0);
        for(int i = p.size(); i < s.size(); ++i) {
            ++sv[s[i]];
            --sv[s[i - p.size()]];
            if(pv == sv) res.push_back(i - p.size() + 1);
        }
        return res;
    }
};


class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> res;
        int m = s.size(), n = p.size();
        if(m < n) return res;
        for(int i = 0; i < m - n + 1; i++){
            if(valid(s.substr(i, n), p)) res.push_back(i);
        }
        return res;
    }
    
    bool valid(string s, string p){
        int words[26] = {0};
        for(int i = 0; i < s.size(); i++){
            words[s[i] - 'a']++;
            words[p[i] - 'a']--;
        }
        for(auto word : words){
            if(word) return false;
        }
        return true;
    }
};