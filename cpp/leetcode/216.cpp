class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<int> ans;
        vector<vector<int>> res;
        help(1, k, n, ans, res);
        return res;
    }
    
    void help(int start, int k, int n, vector<int> &ans, vector<vector<int>> &res){
        if(k == 0 && n == 0){
            res.push_back(ans);
            return;
        }
        for(int i = start; i <= 9; i++){
            ans.push_back(i);
            help(i + 1, k - 1, n - i, ans, res);
            ans.pop_back();
        }
    }
};