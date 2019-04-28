class Solution {
public:
    vector<vector<int> > combine(int n, int k) {
        vector<vector<int> >res;
        if(n < k)return res;
        vector<int> ans;
        dfs(0, k, n, ans, res);
        return res;
    }

    void dfs(int start, int k, int n, vector<int> & ans, vector<vector<int>>&res){
        if(ans.size() == k){
            res.push_back(ans);
            return;
        }
        for(int i = start; i < n; i++){
            ans.push_back(i + 1);
            dfs(i + 1, k, n, ans, res);
            ans.pop_back();
        }
    }
};