class Solution {
public:
    vector<string> wordBreak(string s, unordered_set<string>& wordDict) {
        vector<string> res;
        if(wordDict.find(s) != wordDict.end()) res.push_back(s);
        for(int i = 1; i < s.size(); i++){
            string prefix = s.substr(0, i), suffix = s.substr(i);
            vector<string> rest;
            if(wordDict.find(prefix) == wordDict.end()) continue;
            if(token.find(suffix) != token.end()) rest = token[suffix];
            else rest = wordBreak(suffix, wordDict);
            for(auto strs : rest) res.push_back(prefix + " " + strs);
        }
        token[s] = res;
        return res;
    }
private:
    unordered_map<string, vector<string>> token;
};