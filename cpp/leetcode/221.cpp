class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if(matrix.empty() || matrix[0].empty()) return 0;
        int m = matrix.size(), n = matrix[0].size();
        vector<vector<int>> dp(m + 1, vector<int>(n+1, 0));
        int ans = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; ++j){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1]));
                }
                ans = max(dp[i][j], ans);
            }
        }
        return ans * ans;
    }
};


class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if(matrix.empty() || matrix[0].empty()) return 0;
        int m = matrix.size(), n = matrix[0].size();
        vector<int> dp(n+1, 0);
        int ans = 0, pre = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; ++j){
                if(matrix[i-1][j-1] == '1'){
                    int tmp = dp[j];
                    dp[j] = 1 + min(dp[j-1], min(dp[j], pre));
                    pre = tmp;
                } else {
                    dp[j] = 0;
                }
                ans = max(dp[j], ans);
            }
        }
        return ans * ans;
    }
};