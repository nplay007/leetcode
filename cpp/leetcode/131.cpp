class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> res;
        vector<string> ans;
        dfs(0, s, ans, res);
        return res;
    }
    void dfs(int start, string& s, vector<string>& ans, vector<vector<string>>& res){
        if(start == s.size()){
            res.push_back(ans);
            return;
        }
        for(int i = start; i < s.size(); ++i){
            int l = start, r = i;
            while(l < r && s[l] == s[r]) {l++; r--;}
            if(l >= r){
                ans.pop_back(s.substr(start, i - start + 1)) // i included 
                dfs(i+1, s, ans, res); // start from i + 1
                ans.pop_back();
            }
        }
    }
};