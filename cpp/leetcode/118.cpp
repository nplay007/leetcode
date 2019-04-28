class Solution {
public:
    vector<vector<int>> generate(int n) {
        if(n < 1) return {};
        vector<vector<int>> res(n, vector<int>());
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) res[i].push_back(1);
                else res[i].push_back(res[i-1][j-1] + res[i-1][j]);
            }
        }
        return res;
    }
};