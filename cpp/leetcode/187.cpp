class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        unordered_set<string> res;
        unordered_set<int> st;
        int cur = 0, i = 0;
        while (i < 9) cur = cur << 3 | (s[i++] & 7);
        while (i < s.size()) {
            cur = ((cur & 0x7ffffff) << 3) | (s[i++] & 7);
            if (st.count(cur)) res.insert(s.substr(i - 10, 10));
            else st.insert(cur);
        }
        return vector<string>(res.begin(), res.end());
    }
};


class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        if(s.size() <= 9) return {};
        unordered_map<string, int> hmap;
        for(int i = 0; i < s.size() - 9; i++){
            hmap[s.substr(i, 10)]++;
        }
        vector<string> res;
        for(auto it : hmap){
            if(it.second > 1) res.push_back(it.first);
        }
        return res;
    }
};