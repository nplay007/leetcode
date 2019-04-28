class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;
        vector<int> column(n, -1); // column[i] = j, ith Queen in column j 
        vector<string> ans;
        dfs(0, n, column, ans, res);
        return res;
    }
    
    void dfs(int start, int n, vector<int>& column, vector<string> &ans, vector<vector<string>> &res){
        if(start == n){
            res.push_back(ans);
            return;
        }
        for(int i = 0; i < n; i++){
            if(check(start, i, column)){
                column[start] = i;
                string tmp = string(i, '.') + "Q" + string(n - i - 1, '.');
                ans.push_back(tmp);
                dfs(start+1, n, column, ans, res);
                ans.pop_back();
                column[start] = -1;
            }
        }
    }
    
    bool check(int i, int j, vector<int> &column){
        for(int k = 0; k < i; k++){
            if(column[k] == j || abs(k-i) == abs(j-column[k])) return false;
        }
        return true;
    }
};