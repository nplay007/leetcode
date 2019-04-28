class Solution {
public:
    vector<string> generatePalindromes(string s) {
        unordered_map<char, int> words;
        for(auto ch : s) words[ch]++;
        string part = "", mid = "";
        for(auto it : words){
            if(it.second % 2 == 0) {
                part += string(it.second/2, it.first);
            } else {
                mid += it.first;
                if(mid.size() > 1) return {};
                part += string(it.second/2, it.first);
            }
        }
        vector<string> res;
        dfs(0, mid, part, res);
        return res;
    }
    
    void dfs(int start, string mid, string &part, vector<string> &res){
        if(start == part.size()){
            res.push_back(part + mid + string(part.rbegin(), part.rend()));
            return;
        }
        for(int i = start; i < part.size(); i++){
            if(i > start && part[i] == part[start]) continue;
            swap(part[start], part[i]);
            dfs(start + 1, mid, part, res);
            swap(part[start], part[i]);
        }
    }
};