class Solution {
public:
    vector<string> generateAbbreviations(string word) {
        if(word.empty()) return {""};
        vector<string> res;
        dfs(0, 0, word, "", res);
        return res;
    }
    
    void dfs(int pos, int cnts, string word, string ans, vector<string> &res){
        if(pos == word.size()){
            if(cnts > 0) ans += to_string(cnts);
            res.push_back(ans);
            return;
        }
        if(cnts > 0) {
            dfs(pos + 1, 0, word, ans + to_string(cnts) + word[pos], res);
        } else {
            dfs(pos + 1, 0, word, ans + word[pos], res);
        }
        dfs(pos + 1, cnts + 1, word, ans, res);
    }
};



class Solution {
public:
    vector<string> generateAbbreviations(string word) {
        vector<string> res{word};
        dfs(word, 0, res);
        return res;
    }
    void dfs(string word, int pos, vector<string> &res) {
        for (int i = pos; i < word.size(); ++i) {
            for (int j = 1; i + j <= word.size(); ++j) {
                string t = word.substr(0, i) + to_string(j) + word.substr(i + j);
                res.push_back(t);
                dfs(t, i + 1 + to_string(j).size(), res);
            }
        }
    }
};



class Solution {
public:
    vector<string> generateAbbreviations(string word) {
        vector<string> res;
        res.push_back(word.size() == 0 ? "" : to_string(word.size()));
        for (int i = 0; i < word.size(); ++i) {
            for (auto a : generateAbbreviations(word.substr(i + 1))) {
                string left = i > 0 ? to_string(i) : "";
                res.push_back(left + word.substr(i, 1) + a);
            }
        }
        return res;
    }
};