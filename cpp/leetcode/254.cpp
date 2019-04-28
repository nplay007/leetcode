class Solution {
public:
    vector<vector<int>> getFactors(int n) {
       vector<vector<int>> res;
       vector<int> ans;
       dfs(2, n, ans, res);
       return res;
    }
    
    void dfs(int i, int n, vector<int> &ans, vector<vector<int>> &res){
        for(;i * i <= n; i++){
            if(n % i == 0){
                ans.push_back(i); ans.push_back(n / i);
                res.push_back(ans);
                ans.pop_back();
                dfs(i, n / i, ans, res);
                ans.pop_back();
            }
        }
    }
};